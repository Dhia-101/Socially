package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @ApiOperation(value = "get a specific post")
    @GetMapping(value = "/{postId}")
    public PostDTO getPost(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    @ApiOperation(value = "save a post")
    @PostMapping(value = "")
    public PostDTO savePost(@Valid @RequestBody PostDTO postDTO) {
        return postService.save(postDTO);
    }

    @ApiOperation(value = "update a post")
    @PutMapping(value = "/{postId}")
    public PostDTO updatePost(@PathVariable Long postId ,@Valid @RequestBody PostDTO postDTO) {
        return postService .update(postId, postDTO);
    }

    @ApiOperation(value = "delete a post")
    @DeleteMapping(value = "/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }

}
