package com.dhia.springsocialmediaapi.bootstrap;

import com.dhia.springsocialmediaapi.model.Post;
import com.dhia.springsocialmediaapi.model.User;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public DataLoader(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPosts();
        loadUsers();
    }

    private void loadUsers() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        System.out.println("users loaded...");

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
