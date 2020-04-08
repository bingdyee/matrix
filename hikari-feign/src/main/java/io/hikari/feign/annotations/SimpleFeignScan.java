package io.hikari.feign.annotations;

import io.hikari.feign.framework.FeignClientRegistrar;
import org.springframework.context.annotation.Import;

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
