package io.github.matrix.commons.model.status;

/**
 *
 * 系统默认状态，业务无关
 *
 * @author Bing D. Yee
 * @since 2021/04/07
 */
public enum StatusCode implements StatusInfo {
    /** 正常 */
    OK("00000", "OK"),
    /** 客户端错误 */
    INVALID_REQUEST("A0400", "客户端请求错误"),
    /** 请求资源不存在 */
    NOT_FOUND("A0404", "请求资源不存在"),
    /** 权限不足 */
    FORBIDDEN("A0403", "权限不足"),
    /** 系统执行出错 */
    INTERNAL_SERVER_ERROR("B0001", "系统执行出错"),
    /** 调用第三方服务出错 */
    SERVICE_UNAVAILABLE("C0001", "调用第三方服务出错");;

    final String code;
    final String message;

    StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
