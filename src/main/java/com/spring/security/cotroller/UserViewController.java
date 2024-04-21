package com.spring.security.cotroller;

import com.spring.security.dto.PostUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/")
    public String home() {
        return "user/home";
    }

    @GetMapping("/login")
    public String login(PostUserRequest postUserLogin, Model model) {
        model.addAttribute("postUserLogin", postUserLogin);
        return "user/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @GetMapping("/post")
    public String post() {
        return "user/post";
    }

    @GetMapping("admin")
    public String admin() {
        return "user/admin";
    }
}
