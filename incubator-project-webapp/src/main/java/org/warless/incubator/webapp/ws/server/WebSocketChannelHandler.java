package org.warless.incubator.webapp.ws.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.warless.incubator.webapp.ws.pojo.RequestParam;

public class WebSocketChannelHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {

        } else if (msg instanceof TextWebSocketFrame) {
            RequestParam param = JSONObject.parseObject(((TextWebSocketFrame) msg).text(), RequestParam.class);
            System.err.println(param);
        }
    }

}
