package io.matrix.toolkit.entity;

import io.matrix.toolkit.exception.DefaultErrorCode;
import io.matrix.toolkit.exception.ErrorInfo;

import java.io.Serializable;

/**
 * @author Noa Swartz
 * @date 2020/09/25
 */
public class ResponseResult<E> implements Serializable {

    public static final String OK = "00000";

    private static final long serialVersionUID = -1162713822470138564L;

    private String code;
    private String message;
    private E data;
    private String redirectUri;

    public ResponseResult() {
        this(OK, null, null);
    }

    public ResponseResult(E data) {
        this(OK, null, data);
    }

    public ResponseResult(StatusInfo statusInfo) {
        this(statusInfo.getCode(), statusInfo.getReason(), null);
    }

    public ResponseResult(String code, String message) {
        this(code, message, null);
    }

    public ResponseResult(String code, String message, E data) {
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

    public E getData() {
        return data;
    }

    public void setData(E data) {
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

    public static<T> ResponseResult<T> ok() {
        return new ResponseResult<>();
    }

    public static<T> ResponseResult<T> ok(T data) {
        return new ResponseResult<>(data);
    }

    public static<T> ResponseResult<T> error(ErrorInfo error) {
        return new ResponseResult<>(error);
    }

    public static<T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(DefaultErrorCode.INTERNAL_SERVER_ERROR.as(message));
    }

    public static<T> ResponseResult<T> of(StatusInfo statusInfo) {
        return new ResponseResult<>(statusInfo);
    }

    public static<T> ResponseResult<T> of(String code, String message) {
        return new ResponseResult<>(code, message);
    }

    public static<T> ResponseResult<T> of(String code, String message, T data) {
        return new ResponseResult<>(code, message, data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code='" + code + '\'' +
                ", success=" + getSuccess() +
                ", message='" + message + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", data=" + data +
                '}';
    }

}
