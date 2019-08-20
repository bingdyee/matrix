package org.warless.incubator.oauth2.rbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : yubb
 * @date : 2019-08-19
 */
@MapperScan("org.warless.incubator.oauth2.rbac.mapper")
@SpringBootApplication
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

}
