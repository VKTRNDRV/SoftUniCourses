package com.example.demo.services;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, int age){
        if(username.isBlank() || age < 18){
            throw new RuntimeException("Validation failed");
        }

        //Check username is unique
        Optional<User> byUsername = this.userRepository.findByUsername(username);
        if(byUsername.isPresent()){
            throw new RuntimeException("Username already in use ");
        }

        //add default account
        Account account = new Account();
        User user = new User(username, age, account);

        //save user
        this.userRepository.save(user);
    }



}
