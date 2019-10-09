package org.warless.incubator.dubbo.provider.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.warless.incubator.dubbo.provider.test.service.DefaultServiceTest;
import org.warless.incubator.dubbo.provider.test.service.DemoTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DefaultServiceTest.class,
        DemoTest.class
})
public class MainTest4 {
}
