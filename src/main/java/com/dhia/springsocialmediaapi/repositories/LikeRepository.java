package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {
}
