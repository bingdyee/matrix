package org.warless.incubator.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.warless.incubator.dubbo.api.demo.DefaultService;
import org.warless.incubator.dubbo.api.demo.pojo.dto.UserDTO;

import java.util.Date;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-09-29
 */
@Service(version = "${dubbo.service.version}")
public class DefaultServiceImpl implements DefaultService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String hello(String name) {
        System.err.println("Invoke hello()");
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public UserDTO findUserById(Long id) {
        System.err.println("Invoke findUserById(id)");
        UserDTO user = new UserDTO();
        user.setBirth(new Date());
        user.setId(id);
        user.setUsername("Noa Swartz");
        user.setPassword("546545165498");
        return user;
    }

}
