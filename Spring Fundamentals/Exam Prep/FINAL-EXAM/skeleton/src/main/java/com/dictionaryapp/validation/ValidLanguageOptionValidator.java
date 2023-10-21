package com.dictionaryapp.validation;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidLanguageOptionValidator implements ConstraintValidator<ValidLanguageOption, String> {
    @Override
    public void initialize(ValidLanguageOption constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String option, ConstraintValidatorContext constraintValidatorContext) {
        for(LanguageName languageName : LanguageName.values()){
            if(languageName.name().equals(option)){
                return true;
            }
        }

        return false;
    }
}
