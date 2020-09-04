package io.matrix.spring.boot;

import io.matrix.spring.boot.annotation.EnableMatrixConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Matrix configuration
 *
 * @author Noa Swartz
 * @date 2020/08/15
 */
@Configuration
@ConditionalOnBean(annotation = EnableMatrixConfiguration.class)
@EnableConfigurationProperties(MatrixProperties.class)
public class MatrixAutoConfiguration implements InitializingBean {

    private final MatrixProperties properties;

    public MatrixAutoConfiguration(MatrixProperties properties) {
        this.properties = properties;
    }

    /**
     * test Spring Boot starter
     *
     * @return
     */
    @Bean
    public Random random() {
        return new Random();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // properties check to do here
    }

}
