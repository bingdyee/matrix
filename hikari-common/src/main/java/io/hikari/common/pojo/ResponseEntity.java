package io.hikari.common.pojo;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public class ResponseEntity<T> {

    enum StatusInfo {
        /**
         * The request has succeeded.
         */
        REQUEST_SUCCESS(200,"OK."),
        /**
         * The request could not be understood by the server due to malformed syntax.
         */
        REQUEST_ERROR(400, "Bad Request."),
        /**
         * The request requires user authentication.
         */
        REQUEST_UNAUTHORIZED(401, "Unauthorized."),
        /**
         * login expired
         */
        REQUEST_NOSESSION(402, "Login has expired, please login again."),
        /**
         * The server understood the request, but is refusing to fulfill it.
         */
        REQUEST_FORBIDDEN(403, "Forbidden."),
        /**
         * Not Found
         */
        REQUEST_NOTFOUND(404, "Not Found."),
        /** Request method not supported */
        REQUEST_NOT_ALLOWED(405, "Request method not supported"),
        /**
         * The server encountered an unexpected condition which prevented it from fulfilling the request.
         */
        BUSINESS_FAILURE(500, "Internal Server Error.");

        private final int code;
        private final String message;

        StatusInfo(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    /** 返回码 */
    private int code;
    /** 返回消息提示 */
    private String message;
    /** 返回数据 */
    protected T data;

    public ResponseEntity() {}

    public ResponseEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(StatusInfo statusInfo, T data) {
        this(statusInfo.getCode(), statusInfo.getMessage(), data);
    }

    public ResponseEntity(StatusInfo statusInfo) {
        this(statusInfo.getCode(), statusInfo.getMessage(), null);
    }

    public ResponseEntity(int code, String message) {
        this(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static<T> ResponseEntity<T> ok() {
        return new ResponseEntity<>(StatusInfo.REQUEST_SUCCESS);
    }

    public static<T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(StatusInfo.REQUEST_SUCCESS, data);
    }

    public static<T> ResponseEntity<T> error() {
        return new ResponseEntity<>(StatusInfo.BUSINESS_FAILURE);
    }

    public static<T> ResponseEntity<T> error(String message) {
        return new ResponseEntity<>(StatusInfo.BUSINESS_FAILURE.getCode(), message);
    }

    public static<T> ResponseEntity<T> of(StatusInfo statusInfo) {
        return new ResponseEntity<>(statusInfo);
    }


    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


}

//
//import org.springframework.http.HttpStatus;
//
//public class ResponseEntity<T> {
//
//    /** 返回码 */
//    private int code;
//    /** 返回消息提示 */
//    private String message;
//    /** 返回数据 */
//    protected T data;
//
//    public ResponseEntity() {}
//
//    public ResponseEntity(int code, String message, T data) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
//    }
//
//    public ResponseEntity(HttpStatus status, T data) {
//        this(status.value(), status.getReasonPhrase(), data);
//    }
//
//    public ResponseEntity(HttpStatus status) {
//        this(status.value(), status.getReasonPhrase(), null);
//    }
//
//    public ResponseEntity(int code, String message) {
//        this(code, message, null);
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public static<T> ResponseEntity<T> ok() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    public static<T> ResponseEntity<T> ok(T data) {
//        return new ResponseEntity<>(HttpStatus.OK, data);
//    }
//
//    public static<T> ResponseEntity<T> error() {
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    public static<T> ResponseEntity<T> error(String message) {
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
//    }
//
//    public static<T> ResponseEntity<T> of(HttpStatus status, String message) {
//        return new ResponseEntity<>(status.value(), message);
//    }
//
//    public static<T> ResponseEntity<T> of(HttpStatus status) {
//        return new ResponseEntity<>(status);
//    }
//
//    @Override
//    public String toString() {
//        return "ResponseResult{" +
//                "code=" + code +
//                ", message='" + message + '\'' +
//                ", data=" + data +
//                '}';
//    }
//
//}
