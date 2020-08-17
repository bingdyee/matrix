package io.phorcys.toolkit.validation.annotation;

import io.phorcys.toolkit.validation.PhoneValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

/**
 * @author Noa Swartz
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "Invalid Phone Number!";

    Class[] groups() default {};

    Class[] payload() default {};

}
