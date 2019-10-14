package org.warless.incubator.webapp.ws.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.warless.incubator.webapp.utils.RemoteUtil;
import org.warless.incubator.webapp.ws.pojo.RequestParam;

@ChannelHandler.Sharable
public class WebSocketChannelHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {

        } else if (msg instanceof TextWebSocketFrame) {
            System.err.println(((TextWebSocketFrame) msg).text());
            RequestParam param = JSONObject.parseObject(((TextWebSocketFrame) msg).text(), RequestParam.class);
            ConnectionPool.add(param.getId(), (NioSocketChannel)ctx.channel());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("客户端:[{}] 加入会话", RemoteUtil.parseRemoteAddress(ctx.channel()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        String remoteAddress = RemoteUtil.parseRemoteAddress(ctx.channel());
        logger.info("客户端:[{}] 下线了", remoteAddress);
        ConnectionPool.remove((NioSocketChannel) ctx.channel());
    }
}
