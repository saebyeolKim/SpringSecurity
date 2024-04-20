package com.spring.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 활성화하고 웹 보안 설정 구성
public class SecurityConfig {

    private final DataSource dataSource;
}
