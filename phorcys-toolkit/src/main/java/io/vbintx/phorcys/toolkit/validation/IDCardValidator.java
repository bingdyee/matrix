package io.vbintx.phorcys.toolkit.validation;

import com.google.common.base.Strings;
import io.vbintx.phorcys.toolkit.validation.annotation.IDCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author Noa Swartz
 */
public class IDCardValidator implements ConstraintValidator<IDCard, String> {

    private static final Pattern PATTERN = Pattern.compile("(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Strings.isNullOrEmpty(value) ? Boolean.FALSE :
                PATTERN.matcher(value).matches();
    }

}
