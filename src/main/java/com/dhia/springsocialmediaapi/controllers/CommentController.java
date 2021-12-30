package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.CommentDTO;
import com.dhia.springsocialmediaapi.services.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"comments"})
@RequestMapping()
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation("get post comments")
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getPostComments(@PathVariable Long postId) {
        return commentService.findAll(postId);
    }

    @ApiOperation("get a specific comment")
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public CommentDTO getCommentById(@PathVariable Long postId, @PathVariable Long commentId) {
        return commentService.findById(postId, commentId);
    }

    @ApiOperation("save a comment")
    @PostMapping("/posts/{postId}/comments/add")
    public CommentDTO saveComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        return commentService.save(postId, commentDTO);
    }

    @ApiOperation("update a comment")
    @PutMapping("/posts/{postId}/comments/update/{commentId}")
    public CommentDTO updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentDTO commentDTO) {
        return commentService.update(postId, commentId, commentDTO);
    }

    @ApiOperation("delete a comment")
    @DeleteMapping("/posts/{postId}/comments/delete/{commentId}")
    public CommentDTO deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        return commentService.deleteById(postId, commentId);
    }



}
