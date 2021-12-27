package com.dhia.springsocialmediaapi.mapper;

import com.dhia.springsocialmediaapi.domain.Comment;
import com.dhia.springsocialmediaapi.model.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO commentToCommentDTO(Comment comment);

    Comment CommentDTOToComment(CommentDTO commentDTO);
}
