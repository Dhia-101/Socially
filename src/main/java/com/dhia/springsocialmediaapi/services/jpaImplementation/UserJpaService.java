package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.mapper.UserMapper;
import com.dhia.springsocialmediaapi.model.UserDTO;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import com.dhia.springsocialmediaapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserJpaService implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserJpaService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userMapper.UserToUserDTO(user));
        });
        return users;
    }

    @Override
    public UserDTO findById(Long userId) {
        return userMapper.UserToUserDTO(userRepository.findById(userId).orElse(null));
    }

    @Override
    public UserDTO update(Long aLong, UserDTO object) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if(userDTO.getId() != null)
            throw new RuntimeException("Invalid field: Id.");
        User savedUser = userRepository.save(userMapper.userDTOToUser(userDTO));
        return userMapper.UserToUserDTO(savedUser);
    }

    @Override
    public void delete(Long aLong) {

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
