package com.example.battleships.validations;

import com.example.battleships.domain.dto.UserRegisterModel;
import com.example.battleships.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRegisterModel> {

    private UserRepository userRepository;

    @Autowired
    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {
        return this.userRepository.findFirstByEmail(
                userRegisterModel.getEmail())
                .isEmpty();
    }
}
