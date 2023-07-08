package org.example.services;

import org.example.domain.entities.Game;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    String registerUser(String[] args);

    String loginUser(String[] arguments);

    String logoutUser();

    boolean isLoggedUserAdmin();

    boolean isUserLoggedIn();

    Long getLoggedUserId();

    Set<Game> getGamesByUserId(long id);
}
