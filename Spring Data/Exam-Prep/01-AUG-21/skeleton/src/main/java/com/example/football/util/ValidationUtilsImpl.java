package com.example.football.util;

import javax.validation.Validation;
import javax.validation.Validator;

public class ValidationUtilsImpl implements ValidationUtils{

    private Validator validator;
    @Override
    public <T> boolean isValid(T entity) {
        if(this.validator == null){
            this.validator = Validation
                    .buildDefaultValidatorFactory()
                    .getValidator();
        }

        return this.validator
                .validate(entity)
                .isEmpty();
    }
}
