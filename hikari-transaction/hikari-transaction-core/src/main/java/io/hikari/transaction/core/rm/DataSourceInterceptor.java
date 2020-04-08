package io.hikari.transaction.core.rm;

import io.hikari.transaction.core.GlobalTransactionHolder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.Connection;

/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
public class DataSourceInterceptor implements MethodInterceptor {

    private static final String GET_CONNECTION = "getConnection";
    private static ThreadLocal<ConnectionProxy> connectionProxy = new ThreadLocal<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().getName();
        if (GET_CONNECTION.equals(name) && GlobalTransactionHolder.getCurrentXid() != null) {
            Connection connection = connectionProxy.get();
            if (null == connection) {
                connection =  (Connection) invocation.proceed();
                connection.setAutoCommit(false);
                ConnectionProxy proxy = new ConnectionProxy(connection, GlobalTransactionHolder.getTransaction());
                connectionProxy.set(proxy);
                return proxy;
            }
            return connection;
        }
        return invocation.proceed();
    }

    public static void clear() {
        connectionProxy.remove();
    }

}
