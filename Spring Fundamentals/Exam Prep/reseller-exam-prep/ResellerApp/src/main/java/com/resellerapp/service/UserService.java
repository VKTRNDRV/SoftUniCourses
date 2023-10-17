package com.resellerapp.service;

import com.resellerapp.model.dto.UserLoginBindingModel;
import com.resellerapp.model.dto.UserRegisterBindingModel;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public void logout() {
        loggedUser.setUsername(null);
        loggedUser.setLogged(false);
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean register(UserRegisterBindingModel registerModel) {
        if (registerModel == null) {
            return false;
        }

        String username = registerModel.getUsername();
        if (this.userRepository.findByUsername(username) != null) {
            return false;
        }

        String email = registerModel.getEmail();
        if (this.userRepository.findFirstByEmail(email) != null) {
            return false;
        }

        if(!registerModel.getPassword().equals(
                registerModel.getConfirmPassword())){
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(registerModel.getPassword());
        user.setEmail(registerModel.getEmail());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        User user = findUserByUsername(userLoginBindingModel.getUsername());

        if (user != null && userLoginBindingModel.getPassword()
                .equals(user.getPassword())) {
            loggedUser.setUsername(user.getUsername());
            loggedUser.setLogged(true);

            return true;
        }

        return false;
    }
}
