package com.example.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.eventmanagement.model.User;
import com.example.eventmanagement.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // 🔐 LOGIN API
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        return userService.login(username, password);
    }

    // 📝 REGISTER API
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // 🔍 GET ALL USERS (Optional - for admin testing)
    @GetMapping
    public java.util.List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}