package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Customer;
import exam.model.Town;
import exam.model.dtos.CustomerImportDTO;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;
    private TownRepository townRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils, TownRepository townRepository) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        CustomerImportDTO[] customerDTOs = this.gson
                .fromJson(readCustomersFileContent(), CustomerImportDTO[].class);
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(CustomerImportDTO customerImportDTO : customerDTOs){
            isValid = true;
            Customer customer = null;
            if(this.validationUtils.isValid(customerImportDTO) &&
                    isEmailUnique(customerImportDTO.getEmail())){
                customer = this.modelMapper
                        .map(customerImportDTO, Customer.class);
                customer.setRegisteredOn(customerImportDTO
                        .getRegisteredOnAsLocalDate());

            }else {
                isValid = false;
            }

            // set town
            if(isValid){
                Optional<Town> town = this.townRepository
                        .findFirstByName(customerImportDTO.getTown().getName());
                if(town.isPresent()){
                    customer.setTown(town.get());
                }else {
                    isValid = false;
                }
            }

            if(isValid){
                output.append(String.format(
                        "Successfully imported Customer %s %s - %s\n",
                        customer.getFirstName(), customer.getLastName(),
                        customer.getEmail()));
                this.customerRepository.save(customer);
            }else {
                output.append("Invalid Customer\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isEmailUnique(String email) {
        return this.customerRepository
                .getFirstByEmail(email).isEmpty();
    }
}
