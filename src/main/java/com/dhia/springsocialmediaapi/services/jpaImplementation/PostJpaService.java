package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.model.Post;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;

    public PostJpaService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Set<Post> findAll() {
        Set<Post> posts = new HashSet<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}
