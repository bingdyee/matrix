package io.hikari.common.lock.zk;

import io.hikari.common.lock.DistributedLock;

/**
 * @author Noa Swartz
 */
public class ZooKeeperDistributedLock extends DistributedLock {

    public ZooKeeperDistributedLock() {
        super();
        this.sync = new ZooKeeperSync();
    }

    public ZooKeeperDistributedLock(int timeout) {
        super(timeout);
        this.sync = new ZooKeeperSync();
    }

    final class ZooKeeperSync extends AbstractSync {

        @Override
        protected boolean tryAcquireLock(int timeout) {
            return false;
        }

        @Override
        protected void tryReleaseLock() {

        }

    }

}
