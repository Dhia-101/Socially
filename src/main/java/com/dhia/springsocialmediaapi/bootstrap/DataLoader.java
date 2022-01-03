package com.dhia.springsocialmediaapi.bootstrap;

import com.dhia.springsocialmediaapi.domain.*;
import com.dhia.springsocialmediaapi.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final LikeRepository likeRepository;

    public DataLoader(PostRepository postRepository,
                      UserRepository userRepository,
                      CommentRepository commentRepository,
                      RoleRepository roleRepository,
                      PasswordEncoder passwordEncoder,
                      LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.likeRepository = likeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
    }

    private void loadUsers() {
        Role admin = roleRepository.save(new Role("ROLE_ADMIN"));
        Role user = roleRepository.save(new Role("ROLE_USER")) ;

        Set<Role> roles = new HashSet<>();
        roles.add(admin);
        roles.add(user);




        User user1 = new User("user1",
                "user1lN",
                "foo",
                "foo@email.com",
                passwordEncoder.encode("foo"),
                roles,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>());


        Set<Role> rolesUser2 = new HashSet<>();
        rolesUser2.add(user);
        rolesUser2.add(admin);

        User user2 = new User("user2",
                "user2lN",
                "user2",
                "user2@email.com",
                passwordEncoder.encode("user2"),
                rolesUser2,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>());


        Set<Role> rolesUser3 = new HashSet<>();
        rolesUser3.add(user);

        User user3 = new User("user3",
                "user3lN",
                "user3",
                "user3@email.com",
                passwordEncoder.encode("user3"),
                rolesUser3,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>());

        Post post1 = new Post("post1", user1);
        Post post2 = new Post("post2", user1);
        Post post3 = new Post("post3", user2);



        Comment comment1 = new Comment("comment1", LocalDateTime.now(), post1);
        Comment comment2 = new Comment("comment2", LocalDateTime.now(), post1);
        Comment comment3 = new Comment("comment3", LocalDateTime.now(), post2);

        post1.getComments().add(comment1);
        post1.getComments().add(comment2);
        post2.getComments().add(comment3);

        user1.getPosts().add(post1);
        user1.getPosts().add(post2);

        user2.getPosts().add(post3);

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);

        post1 = postRepository.save(post1);
        post2 = postRepository.save(post2);
        post3 = postRepository.save(post3);

        Like like1 = new Like(post1, user1);
        Like like2 = new Like(post1, user2);

        post1.getLikes().add(like1);
        user1.getLikes().add(like1);

        post1.getLikes().add(like2);
        user2.getLikes().add(like2);

        likeRepository.save(like1);
        likeRepository.save(like2);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

        System.out.println("users loaded...");
        System.out.println("roles loaded...");
        System.out.println("posts loaded...");
        System.out.println("likes loaded...");
        System.out.println("comments loaded...");

    }
}
