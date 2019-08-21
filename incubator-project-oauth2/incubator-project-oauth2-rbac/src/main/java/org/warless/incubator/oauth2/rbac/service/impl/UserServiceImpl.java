package org.warless.incubator.oauth2.rbac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.warless.incubator.common.exception.SystemErrorException;
import org.warless.incubator.common.utils.BeanUtil;
import org.warless.incubator.oauth2.rbac.mapper.UserMapper;
import org.warless.incubator.oauth2.rbac.pojo.dto.UserDTO;
import org.warless.incubator.oauth2.rbac.pojo.po.SysUser;
import org.warless.incubator.oauth2.rbac.service.UserService;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean addUser(UserDTO dto) {
        return null;
    }

    @Override
    public Boolean modifyUser(UserDTO dto) {
        return null;
    }

    @Override
    public Boolean removeUser(Long id) {
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        SysUser user = userMapper.selectById(id);
        if (user == null) {
            throw new SystemErrorException("用户不存在！");
        }
        user.setPassword(null);
        return BeanUtil.copyProperties(user, UserDTO.class);
    }

}
