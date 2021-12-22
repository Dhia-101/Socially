package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
