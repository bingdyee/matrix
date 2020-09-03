package io.matrix.spring.boot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Noa Swartz
 */
public class AutoProxyInvoker implements InvocationHandler {

    private static final int MIN_LEN = 2;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = method.getDeclaringClass();
        System.err.println("Auto Proxy Invoke Method: " + clazz.getName());
        return clazz.getName();
    }

}
