package org.warless.incubator.oauth2.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.warless.incubator.oauth2.database.mapper.SysUserMapper;
import org.warless.incubator.oauth2.database.pojo.po.SysUser;

/**
 * @author yubb
 * @date 2019-08-19
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return new User(user.getUsername(),
                user.getPassword(),
                true, true,
                true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }

}
