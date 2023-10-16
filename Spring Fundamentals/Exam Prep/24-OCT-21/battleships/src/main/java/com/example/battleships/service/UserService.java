package com.example.battleships.service;

import com.example.battleships.domain.dto.UserModel;
import com.example.battleships.domain.entity.User;
import com.example.battleships.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserModel findByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserModel.class);
    }

    public UserModel findById(Long id) {
        return this.modelMapper.map(this.userRepository.findById(id).orElse(new User()), UserModel.class);
    }

    public UserModel findByIdNot(Long id) {
        List<User> users = this.userRepository.findByIdNot(id);
        if(users.isEmpty()){
            return new UserModel();
        }else{
            return this.modelMapper.map(users.get(0), UserModel.class);
        }
    }
}
