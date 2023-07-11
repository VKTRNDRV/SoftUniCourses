package com.example.productsshop.services;

import com.example.productsshop.domain.entities.User;
import com.example.productsshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{

    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void insert(User user){
        this.userRepository.save(user);
    }

    @Override
    public User getRandomUser(){
        long count = this.userRepository.count();
        Random random = new Random();
        long id = random.nextLong(count);
        Optional<User> user = this.userRepository.getRandomUser();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User getRandomUserThatIsNot(User user){
        User extractedUser = getRandomUser();
        while(extractedUser.equals(user)){
            extractedUser = getRandomUser();
        }
        return extractedUser;
    }

    @Override
    public List<User> findUsersWithSoldProductsOrderedByLastNameFirstName(){
        return this.userRepository.findUsersWithSoldProductsOrderedByLastNameFirstName();
    }

    @Override
    public List<User> getUsersWithProductsSold(){
        List<User> allUsers = this.userRepository.findAll();
        for (int i = 0; i < allUsers.size(); i++) {
            User user = this.userRepository.getUserWithSoldProducts(allUsers.get(i));
            if(user != null && user.getSellingProducts().size() > 0){
                allUsers.set(i, user);
            }else {
                allUsers.remove(i);
                i--;
            }
        }
        return allUsers;
    }
}
