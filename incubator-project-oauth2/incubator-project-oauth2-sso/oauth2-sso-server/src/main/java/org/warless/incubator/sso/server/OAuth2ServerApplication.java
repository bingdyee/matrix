package org.warless.incubator.sso.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 *
 * @ https://spring.io/guides/tutorials/spring-boot-oauth2/#_social_login_simple
 *
 * @author fetaxyu
 * @date 2019-08-21
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
