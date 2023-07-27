package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportDTO;
import com.example.football.models.dto.PlayerImportRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Team;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    private TownRepository townRepository;

    private TeamRepository teamRepository;

    private StatRepository statRepository;

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent()  {
        try {
            return Files.readString(Path.of(PLAYERS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importPlayers()  {
        PlayerImportRootDTO root = this.xmlParser.fromString
                (readPlayersFileContent(), PlayerImportRootDTO.class);
        List<PlayerImportDTO> playerDTOs = root.getPlayers();
        StringBuilder output = new StringBuilder();
        for(PlayerImportDTO playerImportDTO : playerDTOs){
            if(this.validationUtils.isValid(playerImportDTO) &&
                    isEmailUnique(playerImportDTO.getEmail())){
                Player player = this.modelMapper
                        .map(playerImportDTO, Player.class);
                player.setBirthDate(playerImportDTO
                        .getBirthDateAsLocalDate());
                player.setStat(this.statRepository.getById(
                        playerImportDTO.getStat().getId()));
                player.setTeam(this.teamRepository.findFirstByName(
                        playerImportDTO.getTeam().getName()).get());
                player.setTown(this.townRepository.findFirstByName(
                        playerImportDTO.getTown().getName()).get());
                output.append(String.format(
                        "Successfully imported Player %s %s - %s\n",
                        player.getFirstName(), player.getLastName(),
                        player.getPosition().toString()));
                this.playerRepository.save(player);
            }else {
                output.append("Invalid Player\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isEmailUnique(String email) {
        return this.playerRepository
                .findFirstByEmail(email).isEmpty();
    }

    @Override
    public String exportBestPlayers() {
        List<Player> players = this.playerRepository.findAll();
        players.sort((p1,p2) -> {
            int result = Float.compare(p2.getStat().getShooting(),
                    p1.getStat().getShooting());
            if(result == 0){
                result = Float.compare(p2.getStat().getPassing(),
                        p1.getStat().getPassing());
            }
            if(result == 0){
                result = Float.compare(p2.getStat().getEndurance(),
                        p1.getStat().getEndurance());
            }
            if(result == 0){
                result = p1.getLastName().compareTo(
                        p2.getLastName());
            }
            return result;
        });
        StringBuilder output = new StringBuilder();
        for(Player player : players){
            Team team = player.getTeam();
            output.append(String.format(
                    "Player - %s %s\n" + "\tPosition - %s\n" +
                    "\tTeam - %s\n" + "\tStadium - %s\n",
                    player.getFirstName(), player.getLastName(),
                    player.getPosition().toString(), team.getName(),
                    team.getStadiumName()));
        }
        return output.toString().trim();
    }
}
