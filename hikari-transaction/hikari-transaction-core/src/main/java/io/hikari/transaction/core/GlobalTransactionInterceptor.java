package io.hikari.transaction.core;

import io.hikari.transaction.common.TransactionStatus;
import io.hikari.transaction.core.annotation.GlobalTransactional;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class GlobalTransactionInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalTransactionInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> targetClass = AopUtils.getTargetClass(invocation.getThis());
        Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
        final Method method = BridgeMethodResolver.findBridgedMethod(specificMethod);
        GlobalTransactional globalTransactionAnnotation = AnnotationUtils.getAnnotation(method, GlobalTransactional.class);;
        Object result = null;
        if (globalTransactionAnnotation != null) {
            String xid = UUID.randomUUID().toString().replace("-", "");
            GlobalTransaction globalTransaction = new GlobalTransaction(xid, TransactionStatus.CREATE);
            GlobalTransactionHolder.setTransaction(globalTransaction);
            globalTransaction.begin();
            try {
                result = invocation.proceed();
                globalTransaction.commit();
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Global Commit xid={}", globalTransaction.getXid());
                }
            } catch (Exception e) {
                globalTransaction.rollback();
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Global Rollback xid={}", globalTransaction.getXid());
                }
                e.printStackTrace();
            }
        } else {
            result = invocation.proceed();
        }
        return result;
    }

}
