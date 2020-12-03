package io.github.matrix.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author Noa Swartz
 */
public class AutoProxyFactory<T> implements FactoryBean<T> {

    public static final String INTERFACE_CLASS_VAR_NAME = "interfaceClass";
    private Class<T> interfaceClass;

    @Override
    public T getObject() {
        AutoProxyInvoker handler = new AutoProxyInvoker();
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