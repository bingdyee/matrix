package io.hikari.oauth2.sso.client2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Client-2 GET.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("Client-2 POST.");
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("Client-2 PUT.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Client-2 DELETE.");
    }

}
