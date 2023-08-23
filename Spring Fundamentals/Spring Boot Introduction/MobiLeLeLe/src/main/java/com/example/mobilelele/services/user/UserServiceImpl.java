package com.example.mobilelele.services.user;

import com.example.mobilelele.models.dtos.UserRegisterFormDto;
import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void registerUser(UserRegisterFormDto userRegisterFormDto){
        User user = this.modelMapper.map(userRegisterFormDto, User.class);
        this.userRepository.save(user);
    }
}
