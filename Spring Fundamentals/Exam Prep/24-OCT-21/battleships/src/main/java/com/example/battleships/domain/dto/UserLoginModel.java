package com.example.battleships.domain.dto;

import com.example.battleships.validations.ValidateLoginForm;

@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
