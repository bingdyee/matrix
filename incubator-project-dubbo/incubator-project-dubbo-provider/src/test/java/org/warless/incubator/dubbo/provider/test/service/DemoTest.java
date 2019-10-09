package org.warless.incubator.dubbo.provider.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.warless.incubator.dubbo.api.demo.DefaultService;
import org.warless.incubator.dubbo.api.demo.pojo.dto.UserDTO;
import org.warless.incubator.dubbo.provider.test.SpringIntegrationTest;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-09
 */
public class DemoTest extends SpringIntegrationTest {

    @Autowired
    private DefaultService defaultService;

    @Test
    public void testFindUserById() {
        System.err.println("testFindUserById()");
        UserDTO user = defaultService.findUserById(Long.MAX_VALUE);
        Assert.assertNotNull(user);
    }

}
