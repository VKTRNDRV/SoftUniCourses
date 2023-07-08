package org.example.services;

public interface GameService {
    String addGame(String[] args);
    String deleteGame(String[] args);
    String editGame(String[] args);

    String getAllGames();

    String getGameDetailsByName(String name);

    String getOwnedGames();
}
