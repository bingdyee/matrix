package org.warless.incubator.dubbo.api.demo;

import org.warless.incubator.dubbo.api.demo.pojo.dto.UserDTO;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-09-29
 */
public interface DefaultService {

    String hello(String name);

    UserDTO findUserById(Long id);

}
