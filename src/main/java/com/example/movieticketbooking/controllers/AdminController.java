package com.example.movieticketbooking.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public ResponseEntity<String> showLoginPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/admin.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return ResponseEntity.ok(htmlContent);
    }

}
