package com.dhia.springsocialmediaapi.mapper;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.model.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO postToPostDTO(Post post);
}
