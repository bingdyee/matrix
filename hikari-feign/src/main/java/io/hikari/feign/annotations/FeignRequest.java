package io.hikari.feign.annotations;


import io.hikari.feign.framework.FeignMethod;

import java.lang.annotation.*;

/**
 * @author : yubb
 * @date : 2019-08-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface FeignRequest {

    String value() default "";

    FeignMethod method() default FeignMethod.GET;

    Class<? extends Annotation> annotation() default Annotation.class;

}
