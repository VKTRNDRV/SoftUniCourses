package org.example.domain.models;

import lombok.Getter;
import lombok.Setter;

import static org.example.constants.ErrorMessages.PASS_MISS_MATCH;

@Getter
@Setter
public class UserLoginDTO {
    private String email;
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void validate(String realPassword) {
        if (!this.password.equals(realPassword)) {
            throw new IllegalArgumentException(PASS_MISS_MATCH);
        }
    }

    public String successfullyLoggedIn() {
        return "User " + this.email + " successfully logged in";
    }
}
