package com.turbo.controller;

import com.turbo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }


    @GetMapping("/forgotPassword")
    public String getForgotPassword(Model model){
        return "forgot-password";
    }

    @GetMapping("/login")
    public String login(Authentication auth, Model model){
//        model.addAttribute("isLogged", auth != null);
//        model.addAttribute("loggedEmail", auth != null ? ((UserDetails)auth.getPrincipal()).getUsername() : "");    // do sprawdzenia właściciela zadania
        model.addAttribute("user", new User());
        return "login";
    }

}
