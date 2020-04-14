package io.hikari.rezkviewer.manager;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class RedisClient {

    private static Map<String, RedissonClient> redissonMap = new ConcurrentHashMap<>();

    public static RedissonClient create(String ip, int port) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(String.format("redis://%s:%d", ip, port))
                .setUsername("")
                .setPassword("");
        RedissonClient redisson = Redisson.create(config);
        redissonMap.put(String.format("%s:%d", ip, port), redisson);
        return redisson;
    }

    public void close(String host) {
        RedissonClient redisson = redissonMap.get(host);
        if (redisson != null) {
            redisson.shutdown();
        }
    }

    public void closeAll() {
        redissonMap.values().forEach(RedissonClient::shutdown);
    }

}
