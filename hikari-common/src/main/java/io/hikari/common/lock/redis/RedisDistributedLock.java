package io.hikari.common.lock.redis;

import io.hikari.common.lock.DistributedLock;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Noa Swartz
 */
public class RedisDistributedLock extends DistributedLock {

    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> new Thread("AutoRefresh-Thread"));
    private static ScheduledFuture<?> future;

    private static final String LOCK_KEY = "redis_lock";

    private JedisPool jedisPool;


    public RedisDistributedLock(JedisPool jedisPool) {
        super();
        this.sync = new RedisSync();
    }

    public RedisDistributedLock(JedisPool jedisPool, int expire) {
        super(expire);
        this.sync = new RedisSync();
    }

    public void init(JedisPool jedisPool) {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(1000);
//        config.setMaxIdle(8);
//        config.setTestOnBorrow(true);
//        jedisPool = new JedisPool(config, host, port, 100000);
    }


    final class RedisSync extends AbstractSync {

        @Override
        protected boolean tryAcquireLock(int timeout) {
            Jedis jedis = jedisPool.getResource();
            if (jedis.incr(LOCK_KEY) > 1) {
                jedis.expire(LOCK_KEY, timeout);
                future = executorService.scheduleAtFixedRate(() -> {
                    jedis.expire(LOCK_KEY, timeout);
                }, 0, timeout - 1, TimeUnit.SECONDS);
                return true;
            }
            return false;
        }

        @Override
        protected void tryReleaseLock() {
            if (future != null) {
                future.cancel(true);
                future = null;
            }
            Jedis jedis = jedisPool.getResource();
            jedis.incrBy(LOCK_KEY, -1);
        }

    }

    public static void main(String[] args) throws IOException {

    }



}
