package org.warless.incubator.simpledubbo.test.service.impl;

import org.warless.incubator.simpledubbo.test.service.HelloService;

/**
 * @author : fetaxyu
 * @date : 2019-09-16
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

}
