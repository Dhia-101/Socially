package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
