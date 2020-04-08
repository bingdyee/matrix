package io.hikari.transaction.core.tm;

import io.hikari.transaction.common.TransactionMessage;
import io.hikari.transaction.common.TransactionStatus;

/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class GlobalTransactionManager {

    private static GlobalTransactionManager INSTANCE = null;

    private GlobalTransactionManager() { }

    public static GlobalTransactionManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalTransactionManager();
        }
        return GlobalTransactionManager.INSTANCE;
    }

    public void begin(String xid) {
        reportStatus(xid, TransactionStatus.CREATE);
    }

    public void commit(String xid) {
        reportStatus(xid, TransactionStatus.GLOBAL_COMMIT);
    }

    public void registry(String xid) {
        reportStatus(xid, TransactionStatus.REGISTRY);
    }

    public void rollback(String xid) {
        reportStatus(xid, TransactionStatus.GLOBAL_ROLLBACK);
    }

    public void branchCommit(String xid) {
        reportStatus(xid, TransactionStatus.BRANCH_COMMIT);
    }

    public void branchRollback(String xid) {
        reportStatus(xid, TransactionStatus.BRANCH_ROLLBACK);
    }

    private void reportStatus(String xid, TransactionStatus status) {
        TMClient.getInstance().sendMessage(TransactionMessage.createMessage(xid, status));
    }

}
