package org.warless.incubator.oauth2.rbac.pojo.dto;

import java.io.Serializable;

/**
 * @author yubb
 * @date 2019-08-20
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -7626864762389824202L;

    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    private String telephone;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
