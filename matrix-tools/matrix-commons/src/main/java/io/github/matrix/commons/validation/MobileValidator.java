package io.github.matrix.commons.validation;

import com.google.common.base.Strings;
import io.github.matrix.commons.constant.RegexConstant;
import io.github.matrix.commons.validation.annotation.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 *
 *
 * @author Bing D. Yee
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
