package com.dhia.springsocialmediaapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    @ApiModelProperty(value = "comment id")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "the post content", required = true)
    private String content;

    @NotNull
    @ApiModelProperty(value = "date of commenting")
    private LocalDateTime dateTimePosted;

}
