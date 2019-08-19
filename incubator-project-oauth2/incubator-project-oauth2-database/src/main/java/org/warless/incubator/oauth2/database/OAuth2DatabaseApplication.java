package org.warless.incubator.oauth2.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : yubb
 * @date : 2019-08-19
 */
@MapperScan("org.warless.incubator.oauth2.database.mapper")
@SpringBootApplication
public class OAuth2DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2DatabaseApplication.class, args);
    }

}
