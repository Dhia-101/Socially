package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.model.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, Long> {
    List<Post> findUserPosts(Long userId);
}
