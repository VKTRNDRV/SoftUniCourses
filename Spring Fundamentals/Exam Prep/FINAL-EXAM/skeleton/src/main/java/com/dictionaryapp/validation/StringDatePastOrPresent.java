package com.dictionaryapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = StringDatePastOrPresentValidator.class)
public @interface StringDatePastOrPresent {

    String message() default "The input date must be a valid date in the past or present.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
