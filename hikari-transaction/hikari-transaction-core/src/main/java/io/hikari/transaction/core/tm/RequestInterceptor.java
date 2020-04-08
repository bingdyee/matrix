package io.hikari.transaction.core.tm;

import io.hikari.transaction.common.Constants;
import io.hikari.transaction.common.TransactionStatus;
import io.hikari.transaction.core.GlobalTransaction;
import io.hikari.transaction.core.GlobalTransactionHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Noa Swartz
 * @date 2020-04-05
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xid = request.getHeader(Constants.XID);
        if (StringUtils.isNotBlank(xid)) {
            GlobalTransaction transaction = new GlobalTransaction(xid, TransactionStatus.REGISTRY);
            transaction.registry();
            GlobalTransactionHolder.setTransaction(transaction);
        }
        return Boolean.TRUE;
    }



}
