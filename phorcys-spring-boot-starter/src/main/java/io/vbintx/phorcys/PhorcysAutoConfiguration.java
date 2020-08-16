package io.vbintx.phorcys;

import io.vbintx.phorcys.annotation.EnableAutoLog;
import io.vbintx.phorcys.annotation.EnablePhorcysConfiguration;
import io.vbintx.phorcys.annotation.ProxyScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Phorcys configuration
 *
 * @author Noa Swartz
 * @date 2020/08/15
 */
@Configuration
@ConditionalOnBean(annotation = EnablePhorcysConfiguration.class)
@EnableConfigurationProperties(PhorcysProperties.class)
public class PhorcysAutoConfiguration {

    @Bean
    public Random random() {
        return new Random();
    }

}
