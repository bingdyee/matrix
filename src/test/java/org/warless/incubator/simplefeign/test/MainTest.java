package org.warless.incubator.simplefeign.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.warless.incubator.simplefeign.SimpleFeignApplication;
import org.warless.incubator.simplefeign.service.TestService;

/**
 * @author : yubb
 * @date : 2019-08-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleFeignApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.listQuestion(2, 3, 1, "10166");
    }

}
