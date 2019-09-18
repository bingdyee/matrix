package org.warless.incubator.dubbo.simpledubbo.service.impl;

import org.warless.incubator.dubbo.simpledubbo.service.SPIService;

/**
 * @author : fetaxyu
 * @date : 2019-09-18
 */
public class SPIServiceImpl implements SPIService {

    @Override
    public void execute(String name) {
        System.err.println("SPIServiceImpl::hello(String name)-" + name);
    }

}
