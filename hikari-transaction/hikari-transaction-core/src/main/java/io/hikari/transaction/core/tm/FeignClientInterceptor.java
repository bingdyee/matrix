package io.hikari.transaction.core.tm;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.hikari.transaction.common.Constants;
import io.hikari.transaction.core.GlobalTransactionHolder;

/**
 * @author Noa Swartz
 * @date 2020-04-05
 */
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(Constants.XID, GlobalTransactionHolder.getCurrentXid());
    }

}
