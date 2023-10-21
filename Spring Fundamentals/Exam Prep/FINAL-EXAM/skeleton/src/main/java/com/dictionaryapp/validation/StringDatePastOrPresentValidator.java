package com.dictionaryapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDatePastOrPresentValidator implements ConstraintValidator<StringDatePastOrPresent, String> {
    @Override
    public void initialize(StringDatePastOrPresent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalDate date = LocalDate.parse(str);

            return !date.isAfter(LocalDate.now());

        }catch (Exception e){
            return false;
        }
    }
}
