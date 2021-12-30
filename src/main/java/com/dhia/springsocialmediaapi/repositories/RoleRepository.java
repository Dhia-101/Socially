package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
