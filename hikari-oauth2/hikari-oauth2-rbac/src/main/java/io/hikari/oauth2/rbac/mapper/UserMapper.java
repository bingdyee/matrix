package io.hikari.oauth2.rbac.mapper;

import io.hikari.oauth2.rbac.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    UserDO selectUserByUsername(@Param("username") String username);

}
