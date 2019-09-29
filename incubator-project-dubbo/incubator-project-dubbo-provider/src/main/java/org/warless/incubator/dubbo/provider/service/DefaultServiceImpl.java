package org.warless.incubator.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.warless.incubator.dubbo.api.demo.DefaultService;

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

}
