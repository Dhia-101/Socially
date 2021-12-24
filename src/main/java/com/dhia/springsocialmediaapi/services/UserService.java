package com.dhia.springsocialmediaapi.services;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.domain.User;

import java.util.List;

public interface UserService extends CrudService<User, Long> {
    List<Post> findUserPosts(Long userId);
}
