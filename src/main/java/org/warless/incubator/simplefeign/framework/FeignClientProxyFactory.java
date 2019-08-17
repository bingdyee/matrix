package org.warless.incubator.simplefeign.framework;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yubb
 * @date 2019-08-16
 */
public class FeignClientProxyFactory<T> implements FactoryBean<T> {

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


}
