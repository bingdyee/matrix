package org.warless.incubator.simplefeign.framework;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author yubb
 * @date 2019-08-16
 */
public class FeignClientProxyFactory<T> implements FactoryBean<T> {

    public static final String INTERFACE_CLASS_VAR_NAME = "interfaceClass";
    private Class<T> interfaceClass;

    @Override
    public T getObject() {
        FeignClientInvoker handler = new FeignClientInvoker();
        return (T) Proxy.newProxyInstance(this.interfaceClass.getClassLoader(),
                new Class[] { this.interfaceClass }, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return this.interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

}
