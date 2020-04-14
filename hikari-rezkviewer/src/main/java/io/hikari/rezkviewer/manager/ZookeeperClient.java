package io.hikari.rezkviewer.manager;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.redisson.api.RedissonClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class ZookeeperClient {

    private static Map<String, CuratorFramework> zkClientMap = new ConcurrentHashMap<>();

    public static CuratorFramework create(String host) {
        CuratorFramework client = CuratorFrameworkFactory
                .newClient(host, new ExponentialBackoffRetry(3000, 3));
        zkClientMap.put(host, client);
        return client;
    }

    public void close(String host) {
        CuratorFramework client = zkClientMap.get(host);
        if (client != null && client.getState().equals(CuratorFrameworkState.STARTED)) {
            client.close();
        }
    }

    public void closeAll() {
        zkClientMap.values().forEach(client -> {
            if (client.getState().equals(CuratorFrameworkState.STARTED)) {
                client.close();
            }
        });
    }

}
