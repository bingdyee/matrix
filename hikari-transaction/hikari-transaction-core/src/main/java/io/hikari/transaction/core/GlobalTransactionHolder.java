package io.hikari.transaction.core;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Noa Swartz
 * @date 2020-04-03
 */
public class GlobalTransactionHolder {

    private static Map<String, GlobalTransaction> TRANSACTION_MAP = new ConcurrentHashMap<>();

    private static ThreadLocal<String> XID = new ThreadLocal<>();

    public static String getCurrentXid() {
        return XID.get();
    }

    public static GlobalTransaction getTransaction() {
        return TRANSACTION_MAP.get(XID.get());
    }

    public static GlobalTransaction getTransaction(String xid) {
        return TRANSACTION_MAP.get(xid);
    }

    public static void setTransaction(GlobalTransaction transaction) {
        XID.set(transaction.getXid());
        TRANSACTION_MAP.putIfAbsent(transaction.getXid(), transaction);
    }

    public static void removeTransaction(String xid) {
        XID.remove();
        TRANSACTION_MAP.remove(xid);
    }

    public static void removeTransaction() {
        TRANSACTION_MAP.remove(XID.get());
        XID.remove();
    }

}
