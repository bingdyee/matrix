package io.hikari.transaction.core.annotation;

import io.hikari.transaction.core.GlobalTransactionInterceptor;
import io.hikari.transaction.core.tm.TMClient;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Method;

/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
public class GlobalTransactionAspectSupport extends AbstractAutoProxyCreator implements InitializingBean {

    private boolean disableGlobalTransaction = false;

    private final Advisor advisor = new DefaultIntroductionAdvisor(new GlobalTransactionInterceptor());

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return new Object[]{advisor};
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!disableGlobalTransaction) {
            TMClient.getInstance().init();
        }
    }

    @Override
    protected boolean shouldSkip(Class<?> beanClass, String beanName) {
        if (disableGlobalTransaction) {
            return Boolean.TRUE;
        }
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            GlobalTransactional txAnnotation = method.getAnnotation(GlobalTransactional.class);
            if (txAnnotation != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
