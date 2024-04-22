package com.spring.security.service;

import com.spring.security.config.SimplePasswordEncoder;
import com.spring.security.dto.PostSignupRequest;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String save(PostSignupRequest userDto) {
        return userRepository.save(userDto.toEntity(passwordEncoder)).getEmail();
    }
}
