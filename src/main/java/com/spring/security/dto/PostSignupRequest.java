package com.spring.security.dto;

import com.spring.security.domain.Member;
import com.spring.security.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSignupRequest {
    private String email;
    private String password;

    @Builder
    public void MemberSignupRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .role(Role.USER)
                .build();
    }
}
