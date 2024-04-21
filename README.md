### * csrf(AbstractHttpConfigurer::disable)
csrf(Cross site Request forgery) : 공격자가 인증된 브라우저에 저장된 쿠키의 세션 정보를 활용하여 웹 서버에 사용자가 의도하지 않은 요청을 전달하는 것. 즉, 정상적인 사용자가 의도치 않은 위조요청을 보내는 것을 의미한다.

### * HttpBasic(), FormLogin()
HttpBasic(), FormLogin() : Json을 통해 로그인을 진행하는데, 로그인 이후 refresh 토큰이 만료되기 전까지 토큰을 통한 인증을 진행할것 이기 때문에 비활성화 하였습니다.

HttpBasic() : Http basic Auth 기반으로 로그인 인증창이 뜬다.

### * authorizeHttpRequests()
anyRequest() : requestMatchers에서 지정된 URL외의 요청에 대한 설정

authenticated() : 해당 URL에 진입하기 위해서는 인증이 필요함

requestMatchers("Url").permitAll() : requestMatchers에서 지정된 url은 인증, 인가 없이도 접근 허용

Url에 /**/ 와 같이 ** 사용 : ** 위치에 어떤 값이 들어와도 적용 (와일드 카드)

hasAuthority() : 해당 URL에 진입하기 위해서 Authorization(인가, 예를 들면 ADMIN만 진입 가능)이 필요함

.hasAuthority(UserRole.ADMIN.name()) 와 같이 사용 가능

### * formLogin()
loginPage() : 로그인 페이지 URL

defaultSuccessURL() : 로그인 성공시 이동할 URL

failureURL() : 로그인 실패시 이동할 URL

### * logout()
invalidateHttpSession() : 로그아웃 이후 전체 세션 삭제 여부

### * sessionManagement()
SessionCreationPolicy() : 정책을 설정합니다.

SessionCreationPolicy.Stateless : 4가지 정책 중 하나로, 스프링 시큐리티가 생성하지 않고 존재해도 사용하지 않습니다. (JWT와 같이 세션을 사용하지 않는 경우에 사용합니다)

참고 블로그

https://velog.io/@woosim34/Spring-Spring-Security-%EC%84%A4%EC%A0%95-%EB%B0%8F-%EA%B5%AC%ED%98%84SessionSpring-boot3.0-%EC%9D%B4%EC%83%81
https://velog.io/@kide77/Spring-Boot-3.x-Security-%EA%B8%B0%EB%B3%B8-%EC%84%A4%EC%A0%95-%EB%B0%8F-%EB%B3%80%ED%99%94
https://devhan.tistory.com/310?category=1111057