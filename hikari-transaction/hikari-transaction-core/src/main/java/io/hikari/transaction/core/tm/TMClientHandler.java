package io.hikari.transaction.core.tm;

import com.alibaba.fastjson.JSON;
import io.hikari.transaction.common.TransactionMessage;
import io.hikari.transaction.common.TransactionStatus;
import io.hikari.transaction.core.GlobalTransaction;
import io.hikari.transaction.core.GlobalTransactionHolder;
import io.hikari.transaction.core.rpc.RpcNettyClientHandler;
import io.netty.channel.ChannelHandlerContext;


/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class TMClientHandler extends RpcNettyClientHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TransactionMessage message = JSON.parseObject((String)msg, TransactionMessage.class);
        GlobalTransaction transaction = GlobalTransactionHolder.getTransaction(message.getXid());
        if (TransactionStatus.GLOBAL_COMMIT.equals(message.getStatus())) {
            transaction.setStatus(TransactionStatus.GLOBAL_COMMIT);
        } else if (TransactionStatus.GLOBAL_ROLLBACK.equals(message.getStatus())) {
            transaction.setStatus(TransactionStatus.GLOBAL_ROLLBACK);
        }
        transaction.getLocker().signal();
    }

}
