package io.hikari.transaction.core.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Noa Swartz
 * @date 2020-04-06
 */
public class RpcNettyClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcNettyClient.class);

    protected String hostname;
    protected int port;
    protected RpcNettyClientHandler handler;
    protected ExecutorService executor;

    public RpcNettyClient(String hostname, int port, RpcNettyClientHandler handler) {
        this.hostname = hostname;
        this.port = port;
        this.handler = handler;
        executor = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                runnable -> new FastThreadLocalThread(runnable, "NettyClient-Thread")
        );
    }

    public void init() {
        executor.execute(this::start);
    }

    private void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("handler", handler);
                        }
                    });
            ChannelFuture future = bootstrap.connect(hostname, port).sync();
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("NettyClient Started under {}:{}", hostname, port);
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error("NettyClient Start Failed!");
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void sendMessage(String data) {
        handler.channelWrite(data);
    }

}
