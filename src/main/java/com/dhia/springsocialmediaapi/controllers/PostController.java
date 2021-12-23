package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.Post;
import com.dhia.springsocialmediaapi.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@Api(tags = {"posts"})
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation("get all posts")
    @GetMapping("")
    public Set<Post> getAllPosts() {
        return postService.findAll();
    }

    @ApiOperation(value = "get a specific post")
    @GetMapping(value = "/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    @ApiOperation(value = "save a post")
    @PostMapping(value = "")
    public Post savePost(@RequestBody Post post) {
        // TODO: check if id already exists
        // TODO: add validation
        return postService.save(post);
    }

}
