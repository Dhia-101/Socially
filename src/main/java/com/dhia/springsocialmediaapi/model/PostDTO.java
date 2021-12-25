package com.dhia.springsocialmediaapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "the publisher id", required = true)
    private Long publisherId;

    @NotNull
    @ApiModelProperty(value = "the post content", required = true)
    private String content;


}
