package org.warless.incubator.oauth2.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fetaxyu
 * @date 2019-08-21
 */
@MapperScan("org.warless.incubator.oauth2.sso.mapper")
@SpringBootApplication
public class OAuth2SsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SsoApplication.class, args);
    }

}
