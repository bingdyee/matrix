package org.warless.incubator.web.framework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }

    public static Entry getMethod(String traCode) {
        return ApplicationStartListener.SERVICE_MAP.get(traCode);
    }

}