package org.warless.incubator.oauth2.rbac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.warless.incubator.oauth2.rbac.pojo.po.RolePermission;

import java.util.List;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
@Mapper
public interface RolePermissionMapper {

    /**
     *  query user role&permission list
     *
     * @param userId sys_user.id
     * @return rolePermissionList
     */
    List<RolePermission> selectUserRolePermissions(@Param("userId") Long userId);

}
