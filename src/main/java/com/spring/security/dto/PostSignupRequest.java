package com.spring.security.dto;

import com.spring.security.domain.Member;
import com.spring.security.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
    }
}
