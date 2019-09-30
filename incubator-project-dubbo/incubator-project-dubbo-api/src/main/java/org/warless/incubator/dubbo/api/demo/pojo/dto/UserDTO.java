package org.warless.incubator.dubbo.api.demo.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -8939981715527024928L;

    private Long id;
    private String username;
    private String password;
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
