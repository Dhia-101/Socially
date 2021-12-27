package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> { }
