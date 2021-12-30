package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.model.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();
    PostDTO findById(Long id);
    PostDTO update(Long id, PostDTO object);
    List<PostDTO> getUserPosts(Long userId);


    PostDTO save(PostDTO object);
    void delete(Long id);
}
