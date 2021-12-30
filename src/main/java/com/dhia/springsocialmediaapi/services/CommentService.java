package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.model.CommentDTO;

public interface CommentService extends CrudService<CommentDTO, Long> {
    CommentDTO save(Long postId, CommentDTO object);
}
