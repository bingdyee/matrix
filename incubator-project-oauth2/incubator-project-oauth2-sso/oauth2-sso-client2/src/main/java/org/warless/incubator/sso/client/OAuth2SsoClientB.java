package org.warless.incubator.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.*;
import org.warless.incubator.common.ResponseEntity;

/**
 * @author : fetaxyu
 * @date : 2019-08-21
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOAuth2Client
@SpringBootApplication
public class OAuth2SsoClientB {


    @RestController
    @RequestMapping("/api")
    public class MainController {

        @PreAuthorize("hasAuthority('USER')")
        @GetMapping("/v1/clientB")
        public ResponseEntity<String> get() {
            return ResponseEntity.ok("ClientB GET.");
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @PostMapping("/v1/clientB")
        public ResponseEntity<String> post() {
            return ResponseEntity.ok("ClientB POST.");
        }

        @PreAuthorize("hasAuthority('USER')")
        @PutMapping("/v1/clientB")
        public ResponseEntity<String> put() {
            return ResponseEntity.ok("ClientB PUT.");
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @DeleteMapping("/v1/clientB")
        public ResponseEntity<String> delete() {
            return ResponseEntity.ok("ClientB DELETE.");
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SsoClientB.class, args);
    }

}
