package org.warless.incubator.dubbo.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.warless.incubator.dubbo.provider.pojo.po.UserDO;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-11
 */
@Mapper
public interface UserMapper {

    /**
     * create user
     *
     * @param user
     * @return
     */
    int insert(UserDO user);

    /**
     *  select by id
     *
     * @param id
     * @return
     */
    UserDO selectById(Long id);



}
