package io.hikari.transaction.server.coordinator;

import com.alibaba.fastjson.JSONObject;
import io.hikari.transaction.common.TransactionMessage;
import io.hikari.transaction.common.TransactionStatus;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class CoordinatorInboundHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoordinatorInboundHandler.class);

    private static Map<String, TransactionGroup> globalTransactionMap = new ConcurrentHashMap<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        TransactionMessage message =  JSONObject.parseObject((String) msg, TransactionMessage.class);
        TransactionGroup transactionGroup = globalTransactionMap.getOrDefault(message.getXid(), new TransactionGroup());
        switch (message.getStatus()) {
            case CREATE: {
                transactionGroup.getChannels().add(ctx.channel());
                transactionGroup.setXid(message.getXid());
                globalTransactionMap.put(message.getXid(), transactionGroup);
                LOGGER.info("Create global transaction with xid={}", message.getXid());
                break;
            }
            case REGISTRY: {
                transactionGroup.getChannels().add(ctx.channel());
                LOGGER.info("Registry branch transaction under xid={}", message.getXid());
                break;
            }
            case BRANCH_COMMIT: {
                transactionGroup.getVotes().add(TransactionStatus.BRANCH_COMMIT);
                LOGGER.info("Branch transaction commit xid={}", message.getXid());
                break;
            }
            case BRANCH_ROLLBACK: {
                transactionGroup.getVotes().add(TransactionStatus.BRANCH_ROLLBACK);
                LOGGER.info("Branch transaction rollback xid={}", message.getXid());
                break;
            }
            case GLOBAL_COMMIT: {
                TransactionStatus status = transactionGroup.getVotes().contains(TransactionStatus.BRANCH_ROLLBACK) ?
                        TransactionStatus.GLOBAL_ROLLBACK : TransactionStatus.GLOBAL_COMMIT;
                controlGlobalTransaction(transactionGroup, status);
                break;
            }
            case GLOBAL_ROLLBACK: {
                controlGlobalTransaction(transactionGroup, TransactionStatus.GLOBAL_ROLLBACK);
                break;
            }
            default: break;
        }
    }

    private void controlGlobalTransaction(TransactionGroup transactionGroup, TransactionStatus status) {
        TransactionMessage transactionMessage = new TransactionMessage();
        transactionMessage.setStatus(status);
        transactionMessage.setXid(transactionGroup.getXid());
        String data = transactionMessage.toString();
        transactionGroup.getChannels().forEach(channel -> channel.writeAndFlush(data));
        LOGGER.info("Control Global transaction status: xid={}, status={}", transactionGroup.getXid(), status);
        globalTransactionMap.remove(transactionGroup.getXid());
    }

}
