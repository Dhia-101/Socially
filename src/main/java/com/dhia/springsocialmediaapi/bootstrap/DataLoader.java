package com.dhia.springsocialmediaapi.bootstrap;

import com.dhia.springsocialmediaapi.model.Post;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.services.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;

    public DataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadPosts();


    }

    private void loadPosts() {
        Post post1 = new Post("post1");
        Post post2 = new Post("post2");
        Post post3 = new Post("post3");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        System.out.println("posts loaded...");
    }

}
