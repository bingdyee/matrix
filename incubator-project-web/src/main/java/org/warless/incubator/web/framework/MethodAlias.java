package org.warless.incubator.web.framework;

import java.lang.annotation.*;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodAlias {

    String value() default "";

    Class<? extends Annotation> annotation() default Annotation.class;

}
