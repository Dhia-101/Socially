package com.dhia.springsocialmediaapi.bootstrap;

import com.dhia.springsocialmediaapi.domain.Comment;
import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.domain.Role;
import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.repositories.CommentRepository;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.repositories.RoleRepository;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final RoleRepository roleRepository;

    public DataLoader(PostRepository postRepository,
                      UserRepository userRepository,
                      CommentRepository commentRepository,
                      RoleRepository roleRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
    }

    private void loadUsers() {
        Role admin = new Role("admin");
        Role user = new Role("user");

        User user1 = new User("user1", "user1lN");
        user1.setRole(admin);

        User user2 = new User("user2", "user2lN");
        user1.setRole(user);

        User user3 = new User("user3", "user3lN");
        user1.setRole(admin);

        Post post1 = new Post("post1", user1);
        Post post2 = new Post("post2", user1);
        Post post3 = new Post("post3", user2);

        Comment comment1 = new Comment("comment1", LocalDate.now(), post1);
        Comment comment2 = new Comment("comment2", LocalDate.now(), post1);
        Comment comment3 = new Comment("comment3", LocalDate.now(), post2);

        post1.getComments().add(comment1);
        post1.getComments().add(comment2);
        post2.getComments().add(comment3);

        user1.getPosts().add(post1);
        user1.getPosts().add(post2);

        user2.getPosts().add(post3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        roleRepository.save(admin);
        roleRepository.save(user);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

        System.out.println("users loaded...");
        System.out.println("roles loaded...");
        System.out.println("posts loaded...");
        System.out.println("comments loaded...");

    }
}
