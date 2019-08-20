package org.warless.incubator.oauth2.rbac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.warless.incubator.oauth2.rbac.mapper.UserMapper;
import org.warless.incubator.oauth2.rbac.pojo.po.User;

/**
 * @author fetaxyu
 * @date 2019-08-19
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = sysUserMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return new UserDetailsImpl(user);
    }

}
