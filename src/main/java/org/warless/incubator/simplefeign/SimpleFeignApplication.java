package org.warless.incubator.simplefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.warless.incubator.simplefeign.annotations.SimpleFeignScan;

/**
 * @author yubb
 * @date 2019-08-16
 */
@SimpleFeignScan("org.warless.incubator.simplefeign.service")
@SpringBootApplication
public class SimpleFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleFeignApplication.class, args);
    }

}
