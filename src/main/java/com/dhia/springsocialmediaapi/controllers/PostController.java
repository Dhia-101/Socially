package com.dhia.springsocialmediaapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @GetMapping("/")
    public String getAllPosts() {
        return "all posts";
    }

}
