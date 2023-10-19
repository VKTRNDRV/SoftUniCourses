package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterDTO registerDTO) {

        User user = new User()
                .setUsername(registerDTO.getUsername())
                .setEmail(registerDTO.getEmail())
                .setPassword(registerDTO.getPassword());

        this.userRepository.save(user);
    }

    public boolean login(UserLoginDTO userLoginDTO) {

        String inputUsername = userLoginDTO.getUsername();

        Optional<User> user = this.userRepository
                .findFirstByUsername(inputUsername);
        if(user.isEmpty()){
            return false;
        }

        if(!user.get().getPassword().equals(
                userLoginDTO.getPassword())){
            return false;
        }

        this.loggedUser.login(inputUsername);
        return true;
    }
}
