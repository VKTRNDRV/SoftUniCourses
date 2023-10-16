package com.example.battleships.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MatchingPasswordsValidator.class)
public @interface MatchingPasswords {

    String message() default "Passwords not matching";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
