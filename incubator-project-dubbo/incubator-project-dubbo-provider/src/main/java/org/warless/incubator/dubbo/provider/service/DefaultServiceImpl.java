package org.warless.incubator.dubbo.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
    )
    @Override
    public UserDTO findUserById(Long id) {
        UserDTO user = new UserDTO();
        user.setBirth(new Date());
        user.setId(id);
        user.setUsername("Noa Swartz");
        user.setPassword("546545165498");
        return user;
    }

}
