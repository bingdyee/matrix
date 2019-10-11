package org.warless.incubator.dubbo.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.warless.incubator.dubbo.api.demo.DefaultService;
import org.warless.incubator.dubbo.api.demo.pojo.dto.UserDTO;
import org.warless.incubator.dubbo.provider.mapper.UserMapper;
import org.warless.incubator.dubbo.provider.pojo.po.UserDO;

import javax.sql.DataSource;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;

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
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setBirth(new Date());
        userDO.setPassword("123456");
        userDO.setUsername("fetaxyu");
        userMapper.insert(userDO);
        UserDTO user = new UserDTO();
        user.setBirth(new Date());
        user.setId(id);
        user.setUsername("Noa Swartz");
        user.setPassword("546545165498");
        return user;
    }

}
