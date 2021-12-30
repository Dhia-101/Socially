package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.model.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Long id);
    List<Post> findUserPosts(Long userId);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    UserDTO save(UserDTO object);
    UserDTO update(Long id, UserDTO object);
    void delete(Long id);


}
