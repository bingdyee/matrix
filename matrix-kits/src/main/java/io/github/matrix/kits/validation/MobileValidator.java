package io.github.matrix.kits.validation;

import com.google.common.base.Strings;
import io.github.matrix.kits.constant.RegexConstant;
import io.github.matrix.kits.validation.annotation.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 *
 *
 * @author Noa Swartz
 * @date 2020/08/16
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    private static final Pattern PATTERN = Pattern.compile(RegexConstant.MOBILE_REG);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Strings.isNullOrEmpty(value) ? Boolean.FALSE :
                PATTERN.matcher(value).matches();
    }

}
