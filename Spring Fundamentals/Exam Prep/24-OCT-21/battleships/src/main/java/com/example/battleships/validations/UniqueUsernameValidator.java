package com.example.battleships.validations;

import com.example.battleships.domain.dto.UserRegisterModel;
import com.example.battleships.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserRegisterModel> {

    private UserRepository userRepository;

    @Autowired
    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {
        String username = userRegisterModel.getUsername();
        return this.userRepository.findFirstByUsername(username).isEmpty();
    }
}
