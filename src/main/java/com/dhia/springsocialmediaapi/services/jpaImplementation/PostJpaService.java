package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.mapper.PostMapper;
import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import com.dhia.springsocialmediaapi.services.PostService;
import com.dhia.springsocialmediaapi.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;

@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;


    public PostJpaService(PostRepository postRepository, UserRepository userRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> posts = new ArrayList<>();
        postRepository.findAll().forEach(post -> {
            posts.add(postMapper.postToPostDTO(post));
        });
        return posts;
    }

    @Override
    public PostDTO findById(Long postId) {
        return postRepository.findById(postId)
                .map(postMapper::postToPostDTO)
                .orElse(null);
    }

    @Override
    public PostDTO save(@Valid PostDTO postDTO) {

        userRepository.findById(Long.valueOf(postDTO.getPublisherId())).
                orElseThrow(() -> new ResourceNotFoundException("No publisher with id: " + postDTO.getPublisherId()));

        Post savedPost = postRepository.save(postMapper.PostDTOToPost(postDTO));
        return postMapper.postToPostDTO(savedPost);
    }

//    @Override
//    public void deleteById(Long postId) {
//        postRepository.deleteById(postId);
//    }

//    @Override
//    public PostDTO findByIdDTO(Long id) {
//        return null;
//    }
}
