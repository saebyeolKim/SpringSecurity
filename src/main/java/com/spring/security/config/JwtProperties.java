package com.spring.security.config;

public interface JwtProperties {
    String SECRET = "secretKey"; //JWT 의 Signatuer 를 해싱할 때 사용되는 비밀 키
    int EXPIRATION_TIME =  864000000; //토큰의 만료 기간이다. 초단위로 계산된다.
    String TOKEN_PREFIX = "Bearer "; //토큰 앞에 붙는 정해진 형식이다. 꼭 Bearer 뒤에 한 칸 공백을 넣어줘야 한다.
    String HEADER_STRING = "Authorization"; //헤더의 Authorization 이라는 항목에 토큰을 넣어줄 것이다.
}
