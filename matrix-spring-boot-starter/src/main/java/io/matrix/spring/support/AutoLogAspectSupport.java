package io.matrix.spring.support;

import io.matrix.spring.annotation.Logging;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.beans.BeansException;

import java.lang.reflect.Method;

/**
 * @author Noa Swartz
 */
public class AutoLogAspectSupport extends AbstractAutoProxyCreator {

    private final Advisor advisor = new DefaultIntroductionAdvisor(new AutoLogMethodInterceptor());

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return new Object[]{advisor};
    }

    @Override
    protected boolean shouldSkip(Class<?> beanClass, String beanName) {
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            Logging txAnnotation = method.getAnnotation(Logging.class);
            if (txAnnotation != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
