package com.example.movieticketbooking.controllers;

import com.example.movieticketbooking.models.User;
import com.example.movieticketbooking.models.UserCredentials;
import com.example.movieticketbooking.services.UserService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@RequestBody UserCredentials userCredentials) {
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        User user = userService.loginUser(email, password);
        if (user != null) {
            System.out.println(user.getEmail() + " " + user.getPassword() + " " + user.getName());
            return ResponseEntity.ok(user);
        } else {
            System.out.println("NULL");
            return ResponseEntity.ok(null);
        }
    }



    @GetMapping("/register")
    public ResponseEntity<String> getRegistrationPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/register.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return ResponseEntity.ok(htmlContent);
    }

    @GetMapping("/login")
    public ResponseEntity<String> showLoginPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/login.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return ResponseEntity.ok(htmlContent);
    }


    @GetMapping("/user")
    public ResponseEntity<String> getUserPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/user.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return ResponseEntity.ok(htmlContent);
    }

    // Other controller methods

    // ...
}
