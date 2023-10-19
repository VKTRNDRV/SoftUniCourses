package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.util.UniqueEmail;
import com.example.spotifyplaylistapp.util.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterDTO {

    @NotBlank
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20 characters")
    @UniqueUsername(message = "Username already taken!!!")
    private String username;

    @NotBlank
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20 characters")
    private String password;

    @Email(message = "not an email")
    @UniqueEmail(message = "Email already taken!!!")
    private String email;

    @Length(min = 3, max = 20, message = "Length must be between 3 and 20 characters")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
