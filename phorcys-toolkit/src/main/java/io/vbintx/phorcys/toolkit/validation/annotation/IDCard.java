package io.vbintx.phorcys.toolkit.validation.annotation;

import io.vbintx.phorcys.toolkit.validation.IDCardValidator;
import io.vbintx.phorcys.toolkit.validation.PhoneValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Noa Swartz
 */
@Documented
@Constraint(validatedBy = IDCardValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IDCard {

    String message() default "Invalid ID Card!";

    Class[] groups() default {};

    Class[] payload() default {};

}
