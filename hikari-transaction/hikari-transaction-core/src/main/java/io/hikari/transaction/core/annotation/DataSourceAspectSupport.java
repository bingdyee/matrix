package io.hikari.transaction.core.annotation;

import io.hikari.transaction.core.rm.DataSourceInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.beans.BeansException;

import javax.sql.DataSource;


/**
 * @author Noa Swartz
 * @date 2020-04-05
 */

public class DataSourceAspectSupport extends AbstractAutoProxyCreator {

    private final Advisor advisor = new DefaultIntroductionAdvisor(new DataSourceInterceptor());

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return new Object[] {advisor};
    }

    @Override
    protected boolean shouldSkip(Class<?> beanClass, String beanName) {
        return !DataSource.class.isAssignableFrom(beanClass);
    }

}
