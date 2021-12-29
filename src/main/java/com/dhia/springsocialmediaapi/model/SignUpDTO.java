package com.dhia.springsocialmediaapi.model;

import lombok.Data;

@Data
public class SignUpDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

}
