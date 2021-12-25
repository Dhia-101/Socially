package com.dhia.springsocialmediaapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @NotNull(message = "publisher id shouldn't be empty")
    private Long publisherId;

    @NotNull
    private String content;


}
