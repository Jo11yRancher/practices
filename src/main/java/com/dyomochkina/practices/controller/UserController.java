package com.dyomochkina.practices.controller;

import com.dyomochkina.practices.model.User;
import com.dyomochkina.practices.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registrstion")
    public String registrstion(){
        return "registration";
    }
    @PostMapping("/registrstion")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/login";
    }
    @GetMapping("/hello")
    public String urlSecure(){
        return "/hello";
    }

}
