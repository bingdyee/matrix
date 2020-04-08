package io.hikari.transaction.core.rpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * @author Noa Swartz
 * @date 2020-04-06
 */
public class RpcNettyClientHandler extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext context;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        context.close();
    }

    public synchronized void channelWrite(String data) {
        context.writeAndFlush(data);
    }

}
