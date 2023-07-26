package exam.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
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
