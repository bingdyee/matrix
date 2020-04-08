package io.hikari.feign;

import io.hikari.feign.framework.SimpleFeignScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@SpringBootApplication
public class FeignApplication {

    @Bean
    public SimpleFeignScannerConfigurer simpleFeignScannerConfigurer() {
        SimpleFeignScannerConfigurer configurer = new SimpleFeignScannerConfigurer();
        configurer.setBasePackage("io.hikari.feign.service");
        return configurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
