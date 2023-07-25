package softuni.exam.instagraphlite.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtils {

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
