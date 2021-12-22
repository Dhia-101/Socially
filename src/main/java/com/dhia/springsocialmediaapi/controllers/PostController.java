package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.Post;
import com.dhia.springsocialmediaapi.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public Set<Post> getAllPosts() {
        return postService.findAll();
    }

}
