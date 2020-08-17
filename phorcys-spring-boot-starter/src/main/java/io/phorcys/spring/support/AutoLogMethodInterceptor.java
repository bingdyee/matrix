package io.phorcys.spring.support;

import io.phorcys.spring.annotation.Logging;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author Noa Swartz
 */
public class AutoLogMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> targetClass = AopUtils.getTargetClass(invocation.getThis());
        Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
        final Method method = BridgeMethodResolver.findBridgedMethod(specificMethod);
        Logging logging = AnnotationUtils.getAnnotation(method, Logging.class);;
        Object result;
        if (logging != null) {
            try {
                System.err.println("Invoke Pre: " + method.getName());
                result = invocation.proceed();
            } finally {
                System.err.println("Invoke Post: " + method.getName());
            }
        } else {
            result = invocation.proceed();
        }
        return result;
    }

}
