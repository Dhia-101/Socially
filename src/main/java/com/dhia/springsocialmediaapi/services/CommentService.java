package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.model.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAll();
    CommentDTO findById(Long postId, Long commentId);
    CommentDTO save(Long postId, CommentDTO object);
    CommentDTO update(Long postId, Long commentId, CommentDTO object);
    void delete(Long id);
}
