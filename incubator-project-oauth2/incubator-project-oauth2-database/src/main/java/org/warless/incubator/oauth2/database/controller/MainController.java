package org.warless.incubator.oauth2.database.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.warless.incubator.common.ResponseEntity;

/**
 * @author : yubb
 * @date : 2019-08-18
 */
@Api(value = "Main Controller", tags = "Main Controller")
@RestController
@RequestMapping("/api")
public class MainController {

    @ApiOperation("GET Request")
    @GetMapping("/v1/main")
    public ResponseEntity<String> get(@RequestParam("name") String name) {
        return ResponseEntity.ok("Get User: " + name + "!");
    }

    @ApiOperation("POST Request")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/main")
    public ResponseEntity<String> post(@RequestParam("name") String name) {
        return ResponseEntity.ok("Add User: " + name + "!");
    }

    @ApiOperation("PUT Request")
    @PutMapping("/v1/main")
    public ResponseEntity<String> put(@RequestParam("name") String name) {
        return ResponseEntity.ok("Modify User: " + name + "!");
    }

    @ApiOperation("DELETE Request")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/v1/main")
    public ResponseEntity<String> delete(@RequestParam("name") String name) {
        return ResponseEntity.ok("Remove User: " + name + "!");
    }

}
