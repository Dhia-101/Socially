package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
