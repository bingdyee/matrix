package io.hikari.feign.test;

import io.hikari.feign.FeignApplication;
import io.hikari.feign.framework.SimpleFeignScannerConfigurer;
import io.hikari.feign.service.DemoFeignClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FeignApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainTest {

    @Autowired
    private DemoFeignClient demoFeignClient;

    @Test
    public void test() {
        Object result = demoFeignClient.listQuestion(2, 3, 1, "10166");
        System.err.println(result);
    }

}
