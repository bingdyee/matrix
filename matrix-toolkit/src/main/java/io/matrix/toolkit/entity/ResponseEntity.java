package io.matrix.toolkit.entity;

import io.matrix.toolkit.exception.DefaultErrorCode;
import io.matrix.toolkit.exception.ErrorInfo;

/**
 * @author Noa Swartz
 * @date 2020/09/01
 */
public class ResponseEntity<T> {

    public static final String OK = "00000";

    private String code;
    private String message;
    private T data;
    private String redirectUri;

    public ResponseEntity() {
        this(OK, null, null);
    }

    public ResponseEntity(T data) {
        this(OK, null, data);
    }

    public ResponseEntity(StatusInfo statusInfo) {
        this(statusInfo.getCode(), statusInfo.getReason(), null);
    }

    public ResponseEntity(String code, String message) {
        this(code, message, null);
    }

    public ResponseEntity(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public boolean getSuccess() {
        return OK.equals(code);
    }

    public static<T> ResponseEntity<T> ok() {
        return new ResponseEntity<>();
    }

    public static<T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(data);
    }

    public static<T> ResponseEntity<T> error(ErrorInfo error) {
        return new ResponseEntity<>(error);
    }

    public static<T> ResponseEntity<T> error(String message) {
        return new ResponseEntity<>(DefaultErrorCode.INTERNAL_SERVER_ERROR.as(message));
    }

    public static<T> ResponseEntity<T> of(StatusInfo statusInfo) {
        return new ResponseEntity<>(statusInfo);
    }

    public static<T> ResponseEntity<T> of(String code, String message) {
        return new ResponseEntity<>(code, message);
    }

    public static<T> ResponseEntity<T> of(String code, String message, T data) {
        return new ResponseEntity<>(code, message, data);
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code='" + code + '\'' +
                ", success=" + getSuccess() +
                ", message='" + message + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", data=" + data +
                '}';
    }

}



