package org.warless.incubator.simplefeign.annotations;

import java.lang.annotation.*;

/**
 * @author : yubb
 * @date : 2019-08-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface FeignBody {

    Class<? extends Annotation> annotation() default Annotation.class;

}
