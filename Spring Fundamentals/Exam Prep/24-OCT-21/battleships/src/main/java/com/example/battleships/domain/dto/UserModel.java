package com.example.battleships.domain.dto;

public class UserModel {
    private Long Id;
    private String username;
    private String fullName;
    private String password;
    private String email;



    public Long getId() {
        return Id;
    }

    public UserModel setId(Long id) {
        Id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
