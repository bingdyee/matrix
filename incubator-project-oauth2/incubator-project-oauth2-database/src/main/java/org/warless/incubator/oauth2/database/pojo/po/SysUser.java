package org.warless.incubator.oauth2.database.pojo.po;

import org.apache.ibatis.type.Alias;
import org.warless.incubator.oauth2.database.pojo.BaseEntity;


/**
 * description: SysUser
 *
 * @author : yubb
 * @date : 2019-08-08
 */
@Alias("SysUser")
public class SysUser extends BaseEntity {

    private String username;
    private String password;
    private String realName;
    private String roles;
    private String telephone;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
