package org.warless.incubator.common;

/**
 * @author : yubb
 * @date : 2019-08-18
 */
public class ResponseEntity<T> {

    public static enum StatusInfo {
        /**
         * The request has succeeded.
         */
        REQUEST_SUCCESS(200,true,"OK."),
        /**
         * The request could not be understood by the server due to malformed syntax.
         */
        REQUEST_ERROR(400, false,"Bad Request."),
        /**
         * The request requires user authentication.
         */
        REQUEST_UNAUTHORIZED(401, false, "Unauthorized."),
        /**
         * login expired
         */
        REQUEST_NOSESSION(402, false, "Login has expired, please login again."),
        /**
         * The server understood the request, but is refusing to fulfill it.
         */
        REQUEST_FORBIDDEN(403, false, "Forbidden."),
        /**
         * Not Found
         */
        REQUEST_NOTFOUND(404, false, "Not Found."),
        /** Request method not supported */
        REQUEST_NOT_ALLOWED(405, false, "Request method not supported"),
        /**
         * The server encountered an unexpected condition which prevented it from fulfilling the request.
         */
        BUSINESS_FAILURE(500, false, "Internal Server Error.");

        private final int code;
        private final boolean success;
        private final String message;

        StatusInfo(int code, boolean success, String message) {
            this.code = code;
            this.success = success;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public boolean getSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

    }

    /** 返回码 */
    protected int code;
    /** 是否成功 */
    private boolean success;
    /** 返回消息提示 */
    private String msg;
    /** 返回数据 */
    protected T data;


    public ResponseEntity() {
        this(StatusInfo.REQUEST_SUCCESS);
    }

    public ResponseEntity(T data) {
        this(StatusInfo.REQUEST_SUCCESS);
        this.data = data;
    }

    public ResponseEntity(boolean success, String message) {
        this.success = success;
        this.msg = message;
    }

    public ResponseEntity(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.msg = message;
    }

    public ResponseEntity(StatusInfo requestForbidden) {
        this.code = requestForbidden.getCode();
        this.msg = requestForbidden.getMessage();
        this.success = requestForbidden.getSuccess();
    }

    public int getCode() {
        return code;
    }

    public ResponseEntity setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity setData(T data) {
        this.data = data;
        return this;
    }

    public static<T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(data);
    }

    public static<T> ResponseEntity ok(T data, String message) {
        return new ResponseEntity<>(data).setMsg(message);
    }

    public static<T> ResponseEntity<T> ok() {
        return new ResponseEntity<>();
    }

    public static<T> ResponseEntity<T> error(String message) {
        return new ResponseEntity<>(StatusInfo.BUSINESS_FAILURE.code, false, message);
    }

    public static<T> ResponseEntity<T> error() {
        return new ResponseEntity<>(StatusInfo.BUSINESS_FAILURE.code, false, null);
    }

    public static<T> ResponseEntity<T> result(StatusInfo statusInfo) {
        return new ResponseEntity<>(statusInfo);
    }

}
