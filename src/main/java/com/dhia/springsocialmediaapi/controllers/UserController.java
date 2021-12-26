package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.model.UserDTO;
import com.dhia.springsocialmediaapi.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"users"})
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "get all users")
    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "get a specific user")
    @GetMapping(value = "/{userId}")
    public UserDTO getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }


}
