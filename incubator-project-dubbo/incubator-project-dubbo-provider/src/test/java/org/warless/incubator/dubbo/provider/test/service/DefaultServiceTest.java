package org.warless.incubator.dubbo.provider.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.warless.incubator.dubbo.api.demo.DefaultService;
import org.warless.incubator.dubbo.provider.test.SpringIntegrationTest;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-09
 */
public class DefaultServiceTest extends SpringIntegrationTest {

    @Autowired
    private DefaultService defaultService;

    @Test
    public void testHello() {
        System.err.println("testHello()");
        defaultService.hello("Now Swartz");
    }

}
