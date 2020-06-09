package com.turbo.controller;

import com.turbo.model.User;
import com.turbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
       return "index";
    }

    @GetMapping("/forgotPassword")
    public String getForgotPassword(Model model){
        return "forgot-password";
    }

    @GetMapping("/login")
    public String login(Authentication auth, Model model){
        model.addAttribute("isLogged", auth != null);
//        userService.registerUser();
        model.addAttribute("user", new User());
       return "login";
    }

    @GetMapping("/service")
    public String service(){
        return "service";
    }

}
