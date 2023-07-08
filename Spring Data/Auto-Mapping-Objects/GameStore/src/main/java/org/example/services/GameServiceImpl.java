package org.example.services;

import org.example.domain.entities.Game;
import org.example.domain.entities.User;
import org.example.domain.models.GameAddDTO;
import org.example.domain.models.GameDetailsDTO;
import org.example.domain.models.GameEditDTO;
import org.example.domain.models.GameNamePriceDTO;
import org.example.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class GameServiceImpl implements GameService{
    private GameRepository gameRepository;
    private UserService userService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
    }


    @Override
    public String addGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        int argsLength = args.length;

        final String title = argsLength > 1 ? args[1] : "";
        final BigDecimal price = argsLength > 2 ? new BigDecimal(args[2]) : BigDecimal.ZERO;
        final float size = argsLength > 3 ? Float.parseFloat(args[3]) : Float.parseFloat("0.0");
        final String trailer = argsLength > 4 ? args[4] : "";
        final String thubnailURL = argsLength > 5 ? args[5] : "";
        final String description = argsLength > 6 ? args[6] : "";
        final LocalDate releaseDate = LocalDate.now();

        final GameAddDTO gameDto;
        try {
            gameDto = new GameAddDTO(title,
                    price,
                    size,
                    trailer,
                    thubnailURL,
                    description,
                    releaseDate);
        }catch (Exception e){
            return e.getMessage();
        }

        Game gameToBeSaved = this.modelMapper.map(gameDto, Game.class);

        Game savedGame = gameRepository.saveAndFlush(gameToBeSaved);

        return gameDto.successfullyAddedGame();
    }

    @Override
    public String deleteGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        final Optional<Game> gameToBeDeleted = this.gameRepository.findById(Long.valueOf(args[1]));

        if (gameToBeDeleted.isEmpty()) return "No Such game";

        this.gameRepository.delete(gameToBeDeleted.get());

        return "Deleted" + gameToBeDeleted.get().getTitle();
    }

    @Override
    public String editGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        final Optional<Game> gameToBeEdited = this.gameRepository.findById(Long.valueOf(args[1]));

        if (gameToBeEdited.isEmpty()) return "No Such game";

        Map<String, String> updatingArguments = new HashMap<>();

        for (int i = 2; i < args.length; i++) {
            String[] argumentsForUpdate = args[i].split("=");
            updatingArguments.put(argumentsForUpdate[0], argumentsForUpdate[1]);
        }
        final GameEditDTO gameEditDto;
        try {
            gameEditDto = this.modelMapper.map(gameToBeEdited.get(), GameEditDTO.class);
        }catch (Exception e){
            return e.getMessage();
        }
        gameEditDto.updateFields(updatingArguments);

        Game gameToBeSaved = this.modelMapper.map(gameEditDto, Game.class);

        this.gameRepository.saveAndFlush(gameToBeSaved);

        return "Edited " + gameEditDto.getTitle();
    }

    @Override
    public String getAllGames() {
        List<Game> allGames = this.gameRepository.findAll();
        StringBuilder output = new StringBuilder();
        if(modelMapper.getTypeMap(Game.class, GameNamePriceDTO.class) == null){
            modelMapper.addMappings(GameNamePriceDTO.CONVERT_TO_DTO_MAP);
        }
        for(Game game : allGames){
            GameNamePriceDTO gameNamePriceDTO = new GameNamePriceDTO();
            modelMapper.map(game, gameNamePriceDTO);
            output.append(gameNamePriceDTO.toString())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    @Override
    public String getGameDetailsByName(String name) {
        Optional<Game> game = this.gameRepository.findByTitle(name);
        if(game.isEmpty()) return "No game with title " + name + " found";
        GameDetailsDTO detailsDTO = new GameDetailsDTO();
        if (modelMapper.getTypeMap(Game.class, GameDetailsDTO.class) == null) {
            modelMapper.addMappings(GameDetailsDTO.CONVERT_TO_DTO_MAP);
        }
        modelMapper.map(game.get(), detailsDTO);
        return detailsDTO.toString();
    }

    @Override
    public String getOwnedGames() {
        if(!this.userService.isUserLoggedIn()) return "No user logged in";
        long id = this.userService.getLoggedUserId();
        Set<Game> games = this.userService.getGamesByUserId(id);
        if(games.isEmpty()) return "No games found";
        StringBuilder output = new StringBuilder();
        if (modelMapper.getTypeMap(Game.class, GameDetailsDTO.class) == null) {
            modelMapper.addMappings(GameDetailsDTO.CONVERT_TO_DTO_MAP);
        }
        for(Game game : games){
            GameNamePriceDTO dto = new GameNamePriceDTO();
            modelMapper.map(game, dto);
            output.append(dto.toString())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
