package org.warless.incubator.dubbo.provider.test;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.warless.incubator.dubbo.api.demo.DefaultService;
import org.warless.incubator.dubbo.provider.ProviderApplication;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-09-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class MainTest {

    @Autowired
    private DefaultService defaultService;

    @Test
    public void test() {
        String result = defaultService.hello("Noa Swartz");
        System.err.println(result);
    }

}
