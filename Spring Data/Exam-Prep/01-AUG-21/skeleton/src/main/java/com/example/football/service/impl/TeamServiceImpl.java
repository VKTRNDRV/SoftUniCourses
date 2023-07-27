package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDTO;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    private TownRepository townRepository;

    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private Gson gson;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() {
        try {
            return Files.readString(Path.of(TEAMS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importTeams() {
        TeamImportDTO[] teamDTOs = this.gson
                .fromJson(readTeamsFileContent(), TeamImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(TeamImportDTO teamImportDTO : teamDTOs){
            if(this.validationUtils.isValid(teamImportDTO) &&
                    isNameUnique(teamImportDTO.getName())){
                Team team = this.modelMapper
                        .map(teamImportDTO, Team.class);
                team.setTown(this.townRepository.findFirstByName(
                        teamImportDTO.getTownName()).get());
                output.append(String.format(
                        "Successfully imported Team %s - %d",
                        team.getName(), team.getFanBase()));
                this.teamRepository.save(team);
            }else {
                output.append("Invalid Team\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.teamRepository
                .findFirstByName(name).isEmpty();
    }
}
