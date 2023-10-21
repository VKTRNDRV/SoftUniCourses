package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.user.UserLoginDTO;
import com.dictionaryapp.model.dto.user.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = this.mapToUser(userRegisterDTO);
        this.userRepository.save(user);
    }

    private User mapToUser(UserRegisterDTO userRegisterDTO) {
        return new User()
                .setUsername(userRegisterDTO.getUsername())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(this.passwordEncoder.encode(
                        userRegisterDTO.getPassword()));
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        Optional<User> user = this.userRepository
                .findFirstByUsername(username);
        if(user.isEmpty()){
            return false;
        }

        if(!this.passwordEncoder.matches(
                userLoginDTO.getPassword(), user.get().getPassword())){
            return false;
        }

        this.loggedUser.login(username);
        return true;
    }
}
