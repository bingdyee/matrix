package org.warless.incubator.oauth2.rbac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.warless.incubator.oauth2.rbac.pojo.po.SysUser;

/**
 * @author : fetaxyu
 * @date : 2019-08-19
 */
@Mapper
public interface UserMapper {

    /**
     * query with username
     *
     * @param username
     * @return
     */
    SysUser selectUserByUsername(@Param("username") String username);

}
