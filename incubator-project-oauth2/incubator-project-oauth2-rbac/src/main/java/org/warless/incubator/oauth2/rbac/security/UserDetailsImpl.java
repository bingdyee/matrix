package org.warless.incubator.oauth2.rbac.security;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.warless.incubator.common.Constants;
import org.warless.incubator.oauth2.rbac.pojo.po.User;

import java.util.Collection;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
public class UserDetailsImpl implements UserDetails {

    private String username;
    @JSONField(serialize=false)
    private String password;
    private int status;


    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.status = user.getStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Constants.ACCOUNT_LOCKED != this.status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Constants.ACCOUNT_ENABLED == this.status;
    }

}
