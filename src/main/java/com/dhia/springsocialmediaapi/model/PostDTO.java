package com.dhia.springsocialmediaapi.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
