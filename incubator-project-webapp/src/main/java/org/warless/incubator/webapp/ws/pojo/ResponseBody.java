package org.warless.incubator.webapp.ws.pojo;

import java.io.Serializable;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-13
 */
public class ResponseBody<T> implements Serializable {

    private int code;
    private String message;
    private T data;
    private long timestamp;

    public ResponseBody(T data) {
        this.code = 200;
        this.timestamp = System.currentTimeMillis();
        this.message = "OK";
        this.data = data;
    }

    public static<T> ResponseBody<T> success(T data) {
        return new ResponseBody<>(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
