package io.hikari.transaction.common;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public enum TransactionStatus {

    /** 开启一个全局事务 */
    CREATE("create"),
    /** 注册一个分支事务 */
    REGISTRY("registry"),
    /** 提交分支事务 */
    BRANCH_COMMIT("branch_commit"),
    /** 提交分支事务 */
    BRANCH_ROLLBACK("branch_rollback"),
    /** 回滚全局事务 */
    GLOBAL_COMMIT("global_commit"),
    /** 回滚全局事务 */
    GLOBAL_ROLLBACK("global_rollback");

    private String status;

    TransactionStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

}
