package io.matrix.toolkit.exception;

/**
 * @author Noa Swartz
 * @date 2020/09/02
 */
public enum DefaultErrorCode implements ErrorInfo {
    /** 客户端错误 */
    INVALID_REQUEST("A0001", "客户端错误"),
    /** 系统执行出错 */
    INTERNAL_SERVER_ERROR("B0001", "系统执行出错"),
    /** 调用第三方服务出错 */
    SERVICE_UNAVAILABLE("C0001", "调用第三方服务出错");

    private final String code;
    private final String reason;

    DefaultErrorCode(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getReason() {
        return reason;
    }

}
