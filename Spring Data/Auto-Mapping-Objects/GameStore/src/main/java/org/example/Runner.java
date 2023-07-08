package org.example;

import org.example.services.GameService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static org.example.constants.Commands.*;

@Component
public class Runner implements CommandLineRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private UserService userService;
    private GameService gameService;

    @Autowired
    public Runner(UserService userService, GameService gameService){
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        String input;

        while (!(input = SCANNER.nextLine()).equals(CLOSE)) {
            final String[] arguments = input.split("\\|");
            final String command = arguments[0];

            final String output = switch (command) {
                case REGISTER_USER -> this.userService.registerUser(arguments);
                case LOG_IN_USER -> this.userService.loginUser(arguments);
                case LOGOUT_USER -> this.userService.logoutUser();
                case ADD_GAME -> this.gameService.addGame(arguments);
                case EDIT_GAME -> this.gameService.editGame(arguments);
                case DELETE_GAME -> this.gameService.deleteGame(arguments);
                case "AllGames" -> this.gameService.getAllGames();
                case "DetailGame" -> this.gameService.getGameDetailsByName(arguments[1]);
                case "OwnedGames" -> this.gameService.getOwnedGames();
                default -> "No command found";
            };

            System.out.println(output);
        }

    }
}
