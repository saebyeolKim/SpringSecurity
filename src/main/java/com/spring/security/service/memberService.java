package com.spring.security.service;

import com.spring.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class memberService {

    private final MemberRepository memberRepository;


}
