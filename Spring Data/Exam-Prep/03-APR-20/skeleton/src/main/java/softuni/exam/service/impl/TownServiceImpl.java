package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TownImportDTO;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private Gson gson;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        TownImportDTO[] townDTOs = this.gson
                .fromJson(readTownsFileContent(), TownImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(TownImportDTO townImportDTO : townDTOs){
            if(this.validationUtil.isValid(townImportDTO) &&
                    isNameUnique(townImportDTO.getName())){
                Town town = this.modelMapper
                        .map(townImportDTO, Town.class);
                output.append(String.format(
                        "Successfully imported Town %s - %d",
                        town.getName(), town.getPopulation()));
                this.townRepository.save(town);
            }else {
                output.append("Invalid Town");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.townRepository.findFirstByName(name).isEmpty();
    }
}
