package io.hikari.oauth2.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@RestController
@RequestMapping("/api/v1/main")
public class MainController {

    @GetMapping
    public ResponseEntity<String> get(@RequestParam("name") String name) {
        return ResponseEntity.ok("Get User: " + name + "!");
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestParam("name") String name) {
        return ResponseEntity.ok("Add User: " + name + "!");
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestParam("name") String name) {
        return ResponseEntity.ok("Modify User: " + name + "!");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("name") String name) {
        return ResponseEntity.ok("Remove User: " + name + "!");
    }

}
