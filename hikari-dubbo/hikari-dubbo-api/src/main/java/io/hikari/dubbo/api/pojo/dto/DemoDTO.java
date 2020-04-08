package io.hikari.dubbo.api.pojo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public class DemoDTO implements Serializable {

    private Long timestamp;
    private String message;
    private String path;
    private Integer status;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DefaultDTO{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", status=" + status +
                '}';
    }

}
