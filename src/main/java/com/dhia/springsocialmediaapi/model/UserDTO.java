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
public class UserDTO {

    @ApiModelProperty(value = "The user id")
    private Long id;

    @ApiModelProperty(value = "user first name")
    private String firstName;

    @ApiModelProperty(value = "user last name")
    private String lastName;

}
