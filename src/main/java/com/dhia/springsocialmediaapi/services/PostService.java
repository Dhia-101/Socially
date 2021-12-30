package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.model.PostDTO;

import java.util.List;

public interface PostService extends CrudService<PostDTO, Long> {
    List<PostDTO> getUserPosts(Long userId);

    PostDTO save(PostDTO object);
}
