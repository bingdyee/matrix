package org.warless.incubator.oauth2.rbac.service;

import org.warless.incubator.oauth2.rbac.pojo.dto.UserDTO;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
public interface UserService {

    /**
     * add user
     *
     * @param dto
     * @return
     */
    Boolean addUser(UserDTO dto);

    /**
     * modify user
     *
     * @param dto
     * @return
     */
    Boolean modifyUser(UserDTO dto);

    /**
     * remove user
     *
     * @param id
     * @return
     */
    Boolean removeUser(Long id);

    /**
     * query user by id
     *
     * @param id
     * @return
     */
    UserDTO getUserById(Long id);


}
