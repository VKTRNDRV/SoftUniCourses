package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeCardImportDTO;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private EmployeeCardRepository employeeCardRepository;

    private Gson gson;
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, Gson gson, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + "employee-cards.json"));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {
        StringBuilder output = new StringBuilder();
        EmployeeCardImportDTO[] cardDTOs = this.gson
                .fromJson(employeeCardsFileContent, EmployeeCardImportDTO[].class);

        for(EmployeeCardImportDTO cardImportDTO : cardDTOs){
            if(!cardImportDTO.containsInvalidNulls() &&
                    areUniqueFieldsValid(cardImportDTO)){
                EmployeeCard employeeCard = this.modelMapper
                        .map(cardImportDTO, EmployeeCard.class);
                this.employeeCardRepository.save(employeeCard);
                output.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                        "Employee Card",
                        employeeCard.getNumber()));
            }else {
                output.append(Constants.INCORRECT_DATA_MESSAGE);
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean areUniqueFieldsValid(EmployeeCardImportDTO cardImportDTO) {
        return this.employeeCardRepository
                .findFirstByNumber(cardImportDTO.getNumber()).isEmpty();
    }
}
