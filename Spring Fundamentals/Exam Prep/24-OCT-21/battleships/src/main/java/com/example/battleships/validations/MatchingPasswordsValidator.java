package com.example.battleships.validations;

import com.example.battleships.domain.dto.UserRegisterModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatchingPasswordsValidator implements ConstraintValidator<MatchingPasswords, UserRegisterModel> {
    @Override
    public void initialize(MatchingPasswords constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {
        return userRegisterModel.getPassword().equals(
                userRegisterModel.getConfirmPassword());
    }
}
