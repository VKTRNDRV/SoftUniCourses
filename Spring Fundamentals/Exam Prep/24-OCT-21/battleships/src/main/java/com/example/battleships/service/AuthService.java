package com.example.battleships.service;

import com.example.battleships.domain.dto.UserLoginModel;
import com.example.battleships.domain.dto.UserRegisterModel;
import com.example.battleships.domain.entity.User;
import com.example.battleships.domain.helper.LoggedUser;
import com.example.battleships.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;


    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegisterModel) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));
    }

    public void loginUser(UserLoginModel userLoginModel) {
        User user = this.userRepository.findFirstByUsername(userLoginModel.getUsername()).get();

        this.loggedUser.setId(user.getId());
    }



    public void logoutUser() {
        loggedUser.clearUser();
    }
}
