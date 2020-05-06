package io.hikari.common.test;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;

/**
 * @author Noa Swartz
 */
public class DistributedLockTest {

    private Redisson redisson;

    @Test
    public void test() {
        RLock lock = redisson.getLock("");
    }

}
