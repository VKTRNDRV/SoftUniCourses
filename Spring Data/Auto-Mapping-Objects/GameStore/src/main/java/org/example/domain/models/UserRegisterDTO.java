package org.example.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;
import static org.example.constants.ErrorMessages.*;
import static org.example.constants.Validations.EMAIL_PATTERN;
import static org.example.constants.Validations.PASSWORD_PATTERN;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class UserRegisterDTO {

    private String email;

    private String password;

    private String confirmPassword;

    private String fullName;

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    private void validate() {

        if (!Pattern.matches(EMAIL_PATTERN, this.email)) {
            throw new IllegalArgumentException(INVALID_EMAIL);
        }

        if (!Pattern.matches(PASSWORD_PATTERN, this.password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }

        if (!this.password.equals(this.confirmPassword)) {
            throw new IllegalArgumentException(PASS_MISS_MATCH);
        }

    }

    public String successfullyRegisteredUser() {
        return fullName + " was registered.";
    }
}
