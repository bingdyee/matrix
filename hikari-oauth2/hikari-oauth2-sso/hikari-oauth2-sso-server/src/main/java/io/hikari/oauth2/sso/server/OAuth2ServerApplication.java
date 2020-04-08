package io.hikari.oauth2.sso.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RestController
@SpringBootApplication
public class OAuth2ServerApplication {


    @GetMapping("/oauth/me")
    public Principal user(Principal principal) {
        return principal;
    }


    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }

}
