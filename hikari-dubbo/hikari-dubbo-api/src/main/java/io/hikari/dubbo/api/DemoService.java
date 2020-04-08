package io.hikari.dubbo.api;

import io.hikari.dubbo.api.pojo.dto.DemoDTO;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public interface DemoService {

    /**
     * test method
     *
     * @param name
     * @return
     */
    DemoDTO doDefault(String name);

}
