package io.hikari.transaction.core;


import io.hikari.transaction.common.Locker;
import io.hikari.transaction.common.TransactionStatus;
import io.hikari.transaction.core.tm.GlobalTransactionManager;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
public class GlobalTransaction {

    private String xid;
    private TransactionStatus status;
    private ThreadPoolExecutor executor;
    private Locker locker = new Locker();

    public GlobalTransaction() { }

    public GlobalTransaction(String xid, TransactionStatus status) {
        this.xid = xid;
        this.status = status;
        executor = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                runnable -> new Thread(runnable, "GlobalTransaction-Thread")
        );
    }

    public void begin() {
        GlobalTransactionManager.getInstance().begin(xid);
    }

    public void registry() {
        GlobalTransactionManager.getInstance().registry(xid);
    }

    public void commit() {
        GlobalTransactionManager.getInstance().commit(xid);
    }

    public void rollback() {
        GlobalTransactionManager.getInstance().rollback(xid);
    }

    public void branchCommit() {
        GlobalTransactionManager.getInstance().branchCommit(xid);
    }

    public void branchRollback() {
        GlobalTransactionManager.getInstance().branchRollback(xid);
    }

    public String getXid() {
        return xid;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Locker getLocker() {
        return locker;
    }

    public void execute(Runnable runnable) {
        if (executor.getActiveCount() == 0) {
            executor.execute(runnable);
        }
    }

}
