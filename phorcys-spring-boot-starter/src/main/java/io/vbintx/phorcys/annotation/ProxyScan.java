package io.vbintx.phorcys.annotation;

import io.vbintx.phorcys.proxy.ProxyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Noa Swartz
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(ProxyRegistrar.class)
public @interface ProxyScan {

    String value() default "";

    Class<? extends Annotation> annotation() default Annotation.class;

}
