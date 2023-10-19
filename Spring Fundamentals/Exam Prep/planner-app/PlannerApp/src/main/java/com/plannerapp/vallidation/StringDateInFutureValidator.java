package com.plannerapp.vallidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StringDateInFutureValidator implements ConstraintValidator<StringDateInFuture, String> {
    @Override
    public void initialize(StringDateInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            try {
                LocalDate parse = LocalDate.parse(value);
                return parse.isAfter(LocalDate.now());

            }catch (Exception e){
                return false;
            }
        }

        return false;
    }
}
