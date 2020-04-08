package io.hikari.transaction.common;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class TransactionMessage {

    private String xid;
    private TransactionStatus status;

    public TransactionMessage() {}

    public TransactionMessage(String xid, TransactionStatus status) {
        this.xid = xid;
        this.status = status;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public static String createMessage(String xid, TransactionStatus status) {
        return new TransactionMessage(xid, status).toString();
    }

    @Override
    public String toString() {
        return'{' + "'xid':'" + xid + "','status':'" + status + "'}";
    }

}
