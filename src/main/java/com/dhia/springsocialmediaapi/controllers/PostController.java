package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@RestController
@Api(tags = {"posts"})
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @ApiOperation("get all posts")
//    @GetMapping("")
//    public Set<Post> getAllPosts() {
//        return postService.findAll();
//    }

    @ApiOperation(value = "get a specific post")
    @GetMapping(value = "/{postId}")
    public PostDTO getPost(@PathVariable Long postId) {
        return postService.findById(postId);
    }



//    @ApiOperation(value = "save a post")
//    @PostMapping(value = "")
//    public Post savePost(@Valid @RequestBody Post post) {
//        return postService.save(post);
//    }

//     @ApiOperation(value = "get a specific post")
//     @GetMapping(value = "/dto/{postId}")
//     public PostDTO findByIdDTO(@PathVariable Long postId) {
//        return new PostDTO(postService.findById(postId));
//
//     }

}
