package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.model.User;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import com.dhia.springsocialmediaapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserJpaService implements UserService {

    private final UserRepository userRepository;

    public UserJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
