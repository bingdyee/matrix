package org.warless.incubator.oauth2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import org.warless.incubator.oauth2.rbac.pojo.po.SysUser;

/**
 * @author : yubb
 * @date : 2019-08-19
 */
public interface SysUserMapper {

    /**
     * query with username
     *
     * @param username
     * @return
     */
    SysUser selectUserByUsername(@Param("username") String username);

}
