package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.mapper.PostMapper;
import com.dhia.springsocialmediaapi.model.PostDTO;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public PostJpaService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

//    @Override
//    public Set<Post> findAll() {
//        Set<Post> posts = new HashSet<>();
//        postRepository.findAll().forEach(posts::add);
//        return posts;
//    }

    @Override
    public PostDTO findById(Long postId) {
        return postRepository.findById(postId)
                .map(postMapper::postToPostDTO)
                .orElse(null);
    }

//    @Override
//    public Post save(Post post) {
//        return postRepository.save(post);
//    }

//    @Override
//    public void deleteById(Long postId) {
//        postRepository.deleteById(postId);
//    }

//    @Override
//    public PostDTO findByIdDTO(Long id) {
//        return null;
//    }
}
