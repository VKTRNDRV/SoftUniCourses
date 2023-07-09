package com.example.productsshop.services;

import com.example.productsshop.domain.entities.User;

public interface UserService {
    void insert(User user);

    User getRandomUser();

    User getRandomUserThatIsNot(User user);
}
