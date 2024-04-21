package com.spring.security.cotroller;

import com.spring.security.dto.PostSignupRequest;
import com.spring.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/loginUser")
    public String postLogin() {
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(PostSignupRequest request) {
        memberService.save(request);
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "user/admin";
    }

    @GetMapping("/post")
    public String post(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("user", user);
        return "user/post";
    }

}
