package org.warless.incubator.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-09-29
 */
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        System.err.println("Provider Application Started!");
    }

}
