package io.hikari.feign.annotations;

import java.lang.annotation.*;

/**
 * @author yubb
 * @date 2019-08-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface FeignClient {

    String value() default "http://127.0.0.1";

    Class<? extends Annotation> annotation() default Annotation.class;

}
