package com.turbo.service;


import com.turbo.model.Role;
import com.turbo.model.User;
import com.turbo.repository.RoleRepository;
import com.turbo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

@Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

/**
Metoda, dzięki której stworzyliśmy przykładowego Usera z zaszyfrowanym hasłem (metoda robocza)
 */
    public void registerUser(){

        User user = new User();
        user.setEmail("turbo@turbo.com");
        Optional<Role> byId = roleRepository.findById(1L);
        Role role = new Role();
        if (byId.isPresent()){
            role = byId.get();
        }
        user.setRole(role);
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode("turbo"));   // szyfrowanie hasła BCrypt
        userRepository.save(user);

    }
}
