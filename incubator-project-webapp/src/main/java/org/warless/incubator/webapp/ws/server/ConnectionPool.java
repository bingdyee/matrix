package org.warless.incubator.webapp.ws.server;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-13
 */
public class ConnectionPool {

    public static Map<Long, NioSocketChannel> CLIENT_POOL = new ConcurrentHashMap<>();


    public static void add(Long key, NioSocketChannel channel) {
        CLIENT_POOL.put(key, channel);
        System.err.println(CLIENT_POOL.size());
    }

    public static void clear() {
        CLIENT_POOL.clear();
    }

    public static NioSocketChannel getClient(Long key) {
        return CLIENT_POOL.get(key);
    }

    public static void remove(NioSocketChannel channel) {
        CLIENT_POOL.values().remove(channel);
    }


}
