package org.warless.incubator.oauth2.rbac.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.warless.incubator.common.ResponseEntity;
import org.warless.incubator.oauth2.rbac.pojo.dto.UserDTO;
import org.warless.incubator.oauth2.rbac.service.UserService;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
@Api(value = "User Controller", tags = "User Controller")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Create user.")
    @PostMapping("/v1/user")
    public ResponseEntity<Boolean> addUser() {
        User u;
        return null;
    }

    @ApiOperation("Delete user.")
    @DeleteMapping("/v1/user")
    public ResponseEntity<Boolean> removeUser(@RequestParam("id") Long id) {
        return null;
    }

    @ApiOperation("Modify user.")
    @PutMapping("/v1/user")
    public ResponseEntity<Boolean> modifyUser() {
        return null;
    }

    @ApiOperation("Get user by id.")
    @GetMapping("/v1/user")
    public ResponseEntity<UserDTO> getUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
