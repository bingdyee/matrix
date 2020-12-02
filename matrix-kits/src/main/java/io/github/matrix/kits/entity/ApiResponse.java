package io.github.matrix.kits.entity;

import io.github.matrix.kits.exception.DefaultErrorCode;
import io.github.matrix.kits.exception.ErrorInfo;

import java.io.Serializable;

/**
 * @author Noa Swartz
 * @date 2020/09/25
 */
public class ApiResponse<E> implements Serializable {

    public static final String OK = "00000";

    private static final long serialVersionUID = -1162713822470138564L;

    private String code;
    private String message;
    private E data;
    private String redirectUri;

    public ApiResponse() {
        this(OK, null, null);
    }

    public ApiResponse(E data) {
        this(OK, null, data);
    }

    public ApiResponse(StatusInfo statusInfo) {
        this(statusInfo.getCode(), statusInfo.getReason(), null);
    }

    public ApiResponse(String code, String message) {
        this(code, message, null);
    }

    public ApiResponse(String code, String message, E data) {
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

    public static<T> ApiResponse<T> ok() {
        return new ApiResponse<>();
    }

    public static<T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(data);
    }

    public static<T> ApiResponse<T> error(ErrorInfo error) {
        return new ApiResponse<>(error);
    }

    public static<T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(DefaultErrorCode.INTERNAL_SERVER_ERROR.as(message));
    }

    public static<T> ApiResponse<T> of(StatusInfo statusInfo) {
        return new ApiResponse<>(statusInfo);
    }

    public static<T> ApiResponse<T> of(String code, String message) {
        return new ApiResponse<>(code, message);
    }

    public static<T> ApiResponse<T> of(String code, String message, T data) {
        return new ApiResponse<>(code, message, data);
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
