package org.warless.incubator.dubbo.provider.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.warless.incubator.dubbo.provider.test.service.DefaultServiceTest;
import org.warless.incubator.dubbo.provider.test.service.DemoTest;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-09-29
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DefaultServiceTest.class,
        DemoTest.class
})
public class MainTest {
}
