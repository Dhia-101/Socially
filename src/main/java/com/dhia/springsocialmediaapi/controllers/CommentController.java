package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.CommentDTO;
import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.services.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"comments"})
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation("get all comments")
    @GetMapping("")
    public List<CommentDTO> getAllComments() {
        return commentService.findAll();
    }

    @ApiOperation("get a specific comment")
    @GetMapping("/{commentId}")
    public CommentDTO getCommentById(@PathVariable Long commentId) {
        return commentService.findById(commentId);
    }

    @ApiOperation("save a comment")
    @PostMapping("/{postId}")
    public CommentDTO saveComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        return commentService.save(postId, commentDTO);
    }



}
