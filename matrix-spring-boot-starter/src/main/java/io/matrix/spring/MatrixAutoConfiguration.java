package io.matrix.spring;

import io.matrix.spring.annotation.EnableMatrixConfiguration;
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
@ConditionalOnBean(annotation = EnableMatrixConfiguration.class)
@EnableConfigurationProperties(MatrixProperties.class)
public class MatrixAutoConfiguration {

    @Bean
    public Random random() {
        return new Random();
    }

}
