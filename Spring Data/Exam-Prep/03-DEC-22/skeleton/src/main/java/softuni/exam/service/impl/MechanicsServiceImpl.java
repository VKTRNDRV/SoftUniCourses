package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Constants;
import softuni.exam.models.dto.MechanicInsertDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class MechanicsServiceImpl implements MechanicsService {

    private MechanicsRepository mechanicsRepository;

    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private ModelMapper modelMapper;
    private Gson gson;

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ModelMapper modelMapper, Gson gson) {
        this.mechanicsRepository = mechanicsRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return this.mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder output = new StringBuilder();
        MechanicInsertDTO[] mechanicInsertDTOs = this.gson
                .fromJson(readMechanicsFromFile(), MechanicInsertDTO[].class);
        for(MechanicInsertDTO mechanicInsertDTO : mechanicInsertDTOs){
            if (isValid(mechanicInsertDTO)) {
                Mechanic mechanic = this.modelMapper.map(mechanicInsertDTO, Mechanic.class);
                this.mechanicsRepository.save(mechanic);
                output.append(String.format(
                        Constants.SUCCESSFULLY_IMPORTED_FORMAT + Constants.MECHANIC_IMPORT_FORMAT,
                        "mechanic", mechanic.getFirstName(), mechanic.getLastName()));
            }else{
                output.append(String.format(Constants.INVALID_FORMAT, "mechanic"));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(MechanicInsertDTO mechanicInsertDTO){
        String firstName = mechanicInsertDTO.getFirstName();
        String lastName = mechanicInsertDTO.getLastName();
        String email = mechanicInsertDTO.getEmail();
        String phone = mechanicInsertDTO.getPhone();
        if(lastName.length() < 2 || firstName.length() < 2 ||
                this.mechanicsRepository.findFirstByFirstName(firstName).isPresent()){
            return false;
        }
        if(email.isEmpty()|| !email.contains("@") || !email.contains(".") ||
                this.mechanicsRepository.findFirstByEmail(email).isPresent()){
            return false;
        }

        // phone is valid if null
        if(!phone.isEmpty()){
            if(phone.length() < 2 || this.mechanicsRepository.findFirstByPhone(phone).isPresent()){
                return false;
            }
        }

        return true;
    }
}
