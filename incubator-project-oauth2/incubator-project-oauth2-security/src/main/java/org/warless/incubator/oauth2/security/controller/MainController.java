package org.warless.incubator.oauth2.security.controller;

import org.springframework.web.bind.annotation.*;
import org.warless.incubator.common.ResponseEntity;

/**
 * @author : yubb
 * @date : 2019-08-18
 */
@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/v1/main")
    public ResponseEntity<String> get(@RequestParam("name") String name) {
        return ResponseEntity.ok("Get User: " + name + "!");
    }

    @PostMapping("/v1/main")
    public ResponseEntity<String> post(@RequestParam("name") String name) {
        return ResponseEntity.ok("Add User: " + name + "!");
    }

    @PutMapping("/v1/main")
    public ResponseEntity<String> put(@RequestParam("name") String name) {
        return ResponseEntity.ok("Modify User: " + name + "!");
    }

    @DeleteMapping("/v1/main")
    public ResponseEntity<String> delete(@RequestParam("name") String name) {
        return ResponseEntity.ok("Remove User: " + name + "!");
    }

}
