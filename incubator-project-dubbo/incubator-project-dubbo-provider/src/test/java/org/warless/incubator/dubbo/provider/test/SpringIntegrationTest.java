package org.warless.incubator.dubbo.provider.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.warless.incubator.dubbo.provider.ProviderApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-09
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
@TestPropertySource("classpath:application-dev.yml")
public class SpringIntegrationTest {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SpringIntegrationTest.class);

    @Ignore("Application is forbidden to startup!")
    @Test
    public void start() {
        LOGGER.info("Application Started!");
        try { System.in.read(); } catch (IOException ignored) {}
    }

    public static void premain(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(ProviderApplication.class);
        Properties props = new Properties();
        InputStream in = ProviderApplication.class.getClassLoader().getResourceAsStream("application-dev.yml");
        props.load(in);
        application.setDefaultProperties(props);
        application.run(args);
    }

}
