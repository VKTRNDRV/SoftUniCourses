package com.example.battleships.domain.dto;

import com.example.battleships.validations.MatchingPasswords;
import com.example.battleships.validations.UniqueEmail;
import com.example.battleships.validations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@UniqueUsername
@MatchingPasswords
@UniqueEmail
public class UserRegisterModel {

    @Size(min = 3, max = 10)
    @NotNull
    private String username;

    @Size(min = 5, max = 20)
    @NotNull
    private String fullName;

    @Size(min = 3)
    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @Email
    @NotNull
    private String email;



    public String getUsername() {
        return username;
    }

    public UserRegisterModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
