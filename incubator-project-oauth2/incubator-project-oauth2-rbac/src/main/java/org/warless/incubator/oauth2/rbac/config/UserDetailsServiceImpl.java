package org.warless.incubator.oauth2.rbac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.warless.incubator.common.Constants;
import org.warless.incubator.oauth2.rbac.mapper.RolePermissionMapper;
import org.warless.incubator.oauth2.rbac.mapper.UserMapper;
import org.warless.incubator.oauth2.rbac.pojo.po.RolePermission;
import org.warless.incubator.oauth2.rbac.pojo.po.SysUser;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fetaxyu
 * @date 2019-08-19
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper sysUserMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        List<RolePermission> permissionList = rolePermissionMapper.selectUserRolePermissions(user.getId());
        Set<GrantedAuthority> authorities = permissionList
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionCode()))
                .collect(Collectors.toSet());
        return new User(user.getUsername(),
                user.getPassword(),
                Constants.ACCOUNT_ENABLED == user.getStatus(),
                true, true,
                Constants.ACCOUNT_LOCKED != user.getStatus(),
                authorities);
    }

}
