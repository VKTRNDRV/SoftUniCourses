package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil{

    private Validator validator;

    @Override
    public <T> boolean isValid(T obj) {
        if(this.validator == null){
            this.validator = Validation
                    .buildDefaultValidatorFactory()
                    .getValidator();
        }
        return this.validator.validate(obj)
                .isEmpty();
    }
}
