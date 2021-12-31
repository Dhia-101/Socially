package com.dhia.springsocialmediaapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post extends BaseEntity {

    public Post(String content, User user) {
        this.content = content;
        this.publisher = user;
    }

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "publisher")
    private User publisher;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Like> likes = new HashSet<>();

    public void addComment(Comment comment) {
        this.getComments().add(comment);
    }


}
