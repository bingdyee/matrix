package io.hikari.transaction.core.tm;


import io.hikari.transaction.core.rpc.RpcNettyClient;
import io.hikari.transaction.core.rpc.RpcNettyClientHandler;

/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class TMClient extends RpcNettyClient {

    private static volatile TMClient instance;

    private TMClient(String hostname, int port, RpcNettyClientHandler handler) {
        super(hostname, port, handler);
    }

    public static TMClient getInstance() {
        return getInstance("127.0.0.1", 8089);
    }

    public static TMClient getInstance(String hostname, int port) {
        if (null == instance) {
            synchronized (TMClient.class) {
                if (null == instance) {
                    instance = new TMClient(hostname, port, new TMClientHandler());
                }
            }
        }
        return instance;
    }

}
