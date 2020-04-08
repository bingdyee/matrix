package io.hikari.oauth2.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RestController
public class OAuth2Controller {


    @GetMapping("/oauth/me")
    public Principal user(Principal principal) {
        return principal;
    }


}
