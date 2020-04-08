package io.hikari.oauth2.memory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@SpringBootApplication
public class OAuth2MemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2MemoryApplication.class, args);
    }

}
