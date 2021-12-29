package com.dhia.springsocialmediaapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @ApiModelProperty(example = "user2")
    private String username;
    @ApiModelProperty(example = "user2")
    private String password;
}
