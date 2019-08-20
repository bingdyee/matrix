package org.warless.incubator.oauth2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import org.warless.incubator.oauth2.rbac.pojo.po.User;

/**
 * @author : yubb
 * @date : 2019-08-19
 */
public interface UserMapper {

    /**
     * query with username
     *
     * @param username
     * @return
     */
    User selectUserByUsername(@Param("username") String username);

}
