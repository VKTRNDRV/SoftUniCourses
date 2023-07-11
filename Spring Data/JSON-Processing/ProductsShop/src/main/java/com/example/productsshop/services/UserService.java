package com.example.productsshop.services;

import com.example.productsshop.domain.entities.User;

import java.util.List;

public interface UserService {
    void insert(User user);

    User getRandomUser();

    User getRandomUserThatIsNot(User user);

    List<User> findUsersWithSoldProductsOrderedByLastNameFirstName();

    List<User> getUsersWithProductsSold();
}
