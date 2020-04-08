package io.hikari.common;

/**
 * @author : yubb
 * @date : 2019-08-19
 */
public abstract class Constants {

    private static final String CHARACTER_SET = "UTF-8";

    /** MySQL record Normal status */
    public static final int DELETE_STATUS_NORMAL = 0;
    /** MySQL record Delete status */
    public static final int DELETE_STATUS_DELETE = 1;

    /** the user is disable */
    public static final int ACCOUNT_DISABLED = 0;
    /** the user is enable */
    public static final int ACCOUNT_ENABLED = 1;
    /** the user is locked */
    public static final int ACCOUNT_LOCKED = 2;

}
