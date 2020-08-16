package io.vbintx.phorcys.toolkit.validation;

import com.google.common.base.Strings;
import io.vbintx.phorcys.toolkit.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 *
 *
 * @author Noa Swartz
 * @date 2020/08/16
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final Pattern PATTERN = Pattern.compile("^1[345789]\\d{10}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Strings.isNullOrEmpty(value) ? Boolean.FALSE :
                PATTERN.matcher(value).matches();
    }

}
