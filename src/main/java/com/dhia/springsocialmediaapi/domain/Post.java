package com.dhia.springsocialmediaapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post extends BaseEntity {

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "publisher")
    private User publisher;
}
