package org.warless.incubator.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.warless.incubator.common.ResponseEntity;

/**
 * @author : fetaxyu
 * @date : 2019-08-21
 */
@SpringBootApplication
public class OAuth2SsoClientA {

    @RestController
    @RequestMapping("/api")
    public class MainController {

        @PreAuthorize("hasAuthority('USER')")
        @GetMapping("/v1/clientA")
        public ResponseEntity<String> get() {
            return ResponseEntity.ok("ClientA GET.");
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @PostMapping("/v1/clientA")
        public ResponseEntity<String> post() {
            return ResponseEntity.ok("ClientA POST.");
        }

        @PreAuthorize("hasAuthority('USER')")
        @PutMapping("/v1/clientA")
        public ResponseEntity<String> put() {
            return ResponseEntity.ok("ClientA PUT.");
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @DeleteMapping("/v1/clientA")
        public ResponseEntity<String> delete() {
            return ResponseEntity.ok("ClientA DELETE.");
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SsoClientA.class, args);
    }

}
