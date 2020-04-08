package io.hikari.dubbo.provider.service;

import io.hikari.dubbo.api.DemoService;
import io.hikari.dubbo.api.pojo.dto.DemoDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
@Service(version = "${dubbo.application.version}")
public class DemoServiceImpl implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public DemoDTO doDefault(String message) {
        DemoDTO result = new DemoDTO();
        result.setTimestamp(System.currentTimeMillis());
        result.setStatus(200);
        result.setMessage(message);
        result.setPath(serviceName);
        return result;
    }

}
