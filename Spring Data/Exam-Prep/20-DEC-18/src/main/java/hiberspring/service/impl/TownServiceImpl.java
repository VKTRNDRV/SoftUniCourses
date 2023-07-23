package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.TownImportDTO;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + "towns.json"));
    }

    @Override
    public String importTowns(String townsFileContent) {
        StringBuilder output = new StringBuilder();
        TownImportDTO[] townDTOs = this.gson
                .fromJson(townsFileContent, TownImportDTO[].class);
        for(TownImportDTO townImportDTO : townDTOs){
            if(!townImportDTO.containsInvalidNulls()){
                Town town = this.modelMapper.map(townImportDTO, Town.class);
                this.townRepository.save(town);
                output.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                        "Town", town.getName()));
            }else {
                output.append(Constants.INCORRECT_DATA_MESSAGE);
            }
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
