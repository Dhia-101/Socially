package com.dhia.springsocialmediaapi.mapper;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.model.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "publisher.id", target = "publisherId")
    PostDTO postToPostDTO(Post post);

    //TODO: map the publisher manually
    Post PostDTOToPost(PostDTO postDTO);

}
