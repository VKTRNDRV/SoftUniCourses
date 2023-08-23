package com.example.mobilelele.models.dtos;

import jakarta.validation.constraints.NotNull;

public class UserLoginFormDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public UserLoginFormDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginFormDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginFormDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
