package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import com.dhia.springsocialmediaapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserJpaService implements UserService {


    private final UserRepository userRepository;

    public UserJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
//        Set<User> users = new HashSet<>();
//        userRepository.findAll().forEach(users::add);
//        return users;
        return null;
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User update(Long aLong, User object) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }

//    @Override
//    public User save(User user) {
//        return userRepository.save(user);
//    }

//    @Override
//    public void deleteById(Long userId) {
//        userRepository.deleteById(userId);
//    }

    @Override
    public List<Post> findUserPosts(Long userId) {
        return null;
    }

//    @Override
//    public List<Post> findUserPosts(Long userId) {
//        return new ArrayList<>(userRepository.findById(userId).orElse(null).getPosts());
//    }
}
