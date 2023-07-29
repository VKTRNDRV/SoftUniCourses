package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class ConstellationServiceImpl implements ConstellationService {

    private ConstellationRepository constellationRepository;

    private static String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtil validationUtil;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        ConstellationImportDTO[] constellationDTOs = this.gson.fromJson(
                readConstellationsFromFile(), ConstellationImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(ConstellationImportDTO constellationImportDTO : constellationDTOs){
            if(this.validationUtil.isValid(constellationImportDTO) &&
                    isNameUnique(constellationImportDTO.getName())){
                Constellation constellation = this.modelMapper.map(
                        constellationImportDTO, Constellation.class);
                output.append(String.format(
                        "Successfully imported constellation %s - %s\n",
                        constellation.getName(), constellation.getDescription()));
                this.constellationRepository.save(constellation);
            }else {
                output.append("Invalid constellation\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.constellationRepository
                .findFirstByName(name)
                .isEmpty();
    }
}
