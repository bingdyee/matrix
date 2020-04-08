package io.hikari.oauth2.rbac.service;

import io.hikari.oauth2.rbac.domain.UserDO;
import io.hikari.oauth2.rbac.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fetaxyu
 * @date 2019-08-19
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        Set<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getCode()))
                .collect(Collectors.toSet());
        return new User(user.getUsername(),
                user.getPassword(),
                1 == user.getStatus(),
                2 != user.getStatus(), 3 != user.getStatus(),
                4 != user.getStatus(),
                authorities);
    }

}
