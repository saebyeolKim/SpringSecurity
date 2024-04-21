package com.spring.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUserRequest {

    private String email;
    private String password;
}
