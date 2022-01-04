package com.dhia.springsocialmediaapi.repositories;

import com.dhia.springsocialmediaapi.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
