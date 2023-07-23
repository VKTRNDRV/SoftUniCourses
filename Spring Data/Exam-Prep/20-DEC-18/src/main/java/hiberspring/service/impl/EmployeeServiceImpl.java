package hiberspring.service.impl;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeImportDTO;
import hiberspring.domain.dtos.EmployeeImportDtoWrapper;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.EmployeeService;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private XmlParser xmlParser;

    private ModelMapper modelMapper;

    private EmployeeCardRepository employeeCardRepository;

    private BranchRepository branchRepository;

    private ProductRepository productRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               XmlParser xmlParser, ModelMapper modelMapper,
                               EmployeeCardRepository employeeCardRepository,
                               BranchRepository branchRepository,
                               ProductRepository productRepository) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + "employees.xml"));
    }

    @Override
    public String importEmployees() throws JAXBException {
        StringBuilder output = new StringBuilder();
        String xml = "<employees></employees>";
        try {
            xml = readEmployeesXmlFile();
        } catch (IOException ignored) {}

        EmployeeImportDtoWrapper wrapper = this.xmlParser
                .parseXml(EmployeeImportDtoWrapper.class, xml);
        List<EmployeeImportDTO> employeeDTOs = wrapper
                .getEmployeeImportDTOs();
        boolean isValid;
        for(EmployeeImportDTO employeeImportDTO : employeeDTOs){
            isValid = !employeeImportDTO.containsInvalidNulls();
            Branch branch = null;
            EmployeeCard employeeCard = null;
            if(isValid){
                Optional<Branch> branchOptional = this.branchRepository
                        .findFirstByName(employeeImportDTO.getBranch());
                Optional<EmployeeCard> cardOptional = this.employeeCardRepository
                        .findFirstByNumber(employeeImportDTO.getCard());
                if(branchOptional.isPresent() && cardOptional.isPresent() &&
                        this.employeeRepository
                                .findFirstByCard(cardOptional.get())
                                .isEmpty()){
                    branch = branchOptional.get();
                    employeeCard = cardOptional.get();
                }else {
                    isValid = false;
                }
            }

            if(isValid){
                Employee employee = this.modelMapper
                        .map(employeeImportDTO, Employee.class);
                employee.setBranch(branch);
                employee.setCard(employeeCard);
                this.employeeRepository.save(employee);
                output.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                        "Employee",
                        String.join(" ",
                                employee.getFirstName(),
                                employee.getLastName())));
            }else {
                output.append(String.format(Constants.INCORRECT_DATA_MESSAGE));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {
        List<Branch> branches = this.productRepository
                .getBranchesWithProducts();
        List<Employee> employees = this.employeeRepository
                .findAllByBranchIn(branches);
        employees.sort((e1, e2) -> {
            int result = e1.getFirstName()
                    .compareTo(e2.getFirstName());
            if(result == 0){
                result = e1.getLastName()
                        .compareTo(e2.getLastName());
            }
            if(result == 0){
                result = Integer.compare(
                        e2.getPosition().length(),
                        e1.getPosition().length());
            }
            return result;
        });
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            output.append(String.format("Name: %s\n",
                    String.join(" ",
                            employee.getFirstName(),
                            employee.getLastName())));
            output.append(String.format("Position: %s\n",
                    employee.getPosition()));
            output.append(String.format("Card Number: %s\n",
                    employee.getCard().getNumber()));
            if(i < employees.size() - 1){
                output.append("-------------------------\n");
            }
        }
        return output.toString().trim();
    }
}
