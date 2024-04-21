package com.spring.security.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override //사용자의 id 반환 (고유한 값)
    public String getUsername() {
        return email;
    }

    @Override //계정 만료 여부 현황
    public boolean isAccountNonExpired() {
        return true; //true : 만료되지 않았을 시 true 반환
    }

    @Override //계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true; //true : 잠금되지 않았을 시 true 반환
    }

    @Override //패스워드 만료 여부 현황
    public boolean isCredentialsNonExpired() {
        return true; //true : 만료되지 않았을 시 true 반환
    }

    @Override // 게정 사용 가능 여부 반환
    public boolean isEnabled() {
        return true; //true : 계정이 사용 가능할 시 true 반환
    }
}
