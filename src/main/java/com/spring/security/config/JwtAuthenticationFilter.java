package com.spring.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.domain.Member;
import com.spring.security.dto.PostSignupRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 1. request에 있는 username과 password를 파싱해서 자바 Object로 받기
        ObjectMapper objectMapper = new ObjectMapper();
        PostSignupRequest loginRequestDto = null;
        try {
            loginRequestDto = objectMapper.readValue(request.getInputStream(), PostSignupRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. username, password로 Token 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword());

        // 3. 2번에서 만든 Token으로 로그인 시도
        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        Member customUserDetails = (Member) authentication.getPrincipal();

        // 4.리턴시 authentication객체가 session영역에 저장
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Member customUserDetails = (Member) authResult.getPrincipal();

        // 1. JWT토큰 생성 (빌더패턴)
        String jwtToken = JWT.create()
                .withSubject(customUserDetails.getEmail()) //토큰 이름
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME)) //토큰 만료 설정
                .withClaim("id", customUserDetails.getId()) //비공개 클레임
                .withClaim("username", customUserDetails.getEmail())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));  //HMAC512 : 서버만 아는 secret 값

        // 2. header에 JWT토큰을 넣어서 응답
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX+jwtToken);
    }
}
