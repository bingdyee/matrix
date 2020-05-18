package io.hikari.jooq.pojo.po;

import io.hikari.common.pojo.BasePO;

import java.util.Date;

/**
 * @author Noa Swartz
 */
public class SysUserPO extends BasePO {

    private String username;
    private String password;
    private Integer status;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
