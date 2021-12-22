package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
