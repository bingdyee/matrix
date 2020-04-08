package io.hikari.transaction.core.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author Noa Swartz
 * @date 2020-04-02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GlobalTransactional {

    /**
     * Given group name of the global transaction instance.
     *
     * @return name
     */
    @AliasFor("value")
    String name() default "";

    @AliasFor("name")
    String value() default "";

    /**
     * Global transaction timeoutMills in MILLISECONDS.
     *
     * @return timeout milliseconds
     */
    int timeoutMills() default 60000;

}
