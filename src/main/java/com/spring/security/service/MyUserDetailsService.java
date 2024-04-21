package com.spring.security.service;

import com.spring.security.domain.Member;
import com.spring.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name()).build();
    }
}
