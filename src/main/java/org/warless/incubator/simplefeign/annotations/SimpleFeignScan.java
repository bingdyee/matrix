package org.warless.incubator.simplefeign.annotations;

import org.springframework.context.annotation.Import;
import org.warless.incubator.simplefeign.framework.FeignClientRegistrar;

import java.lang.annotation.*;

/**
 * @author : yubb
 * @date : 2019-08-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(FeignClientRegistrar.class)
public @interface SimpleFeignScan {

    String value() default "";

    Class<? extends Annotation> annotation() default Annotation.class;


}
