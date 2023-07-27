package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private Gson gson;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() {
        try {
            return Files.readString(Path.of(TOWNS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importTowns() {
        TownImportDTO[] townDTOs = this.gson
                .fromJson(readTownsFileContent(), TownImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(TownImportDTO townImportDTO : townDTOs){
            if(this.validationUtils.isValid(townImportDTO) &&
                    isNameUnique(townImportDTO.getName())){
                Town town = this.modelMapper
                        .map(townImportDTO, Town.class);
                output.append(String.format(
                        "Successfully imported Town %s - %d\n",
                        town.getName(), town.getPopulation()));
                this.townRepository.save(town);
            }else {
                output.append("Invalid Town\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.townRepository
                .findFirstByName(name).isEmpty();
    }
}
