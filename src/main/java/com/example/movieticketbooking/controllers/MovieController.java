package com.example.movieticketbooking.controllers;

import com.example.movieticketbooking.models.Movie;
import com.example.movieticketbooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<String> createMovie() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/add_movie.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        return ResponseEntity.ok(htmlContent);
    }

    @PostMapping
    public ResponseEntity<String> createMovie(@RequestParam("name") String name,
                                              @RequestParam("language") String language,
                                              @RequestParam("durationMinutes") String durationMinutes,
                                              @RequestParam("imageUrl") String imageUrl) {
        try {
            Movie movie = new Movie();
            movie.setName(name);
            movie.setLanguage(language);
            movie.setDurationMinutes(durationMinutes);
            movie.setImageUrl(imageUrl);

            movieService.createMovie(movie);
            return ResponseEntity.ok("Movie created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
            return ResponseEntity.status(500).body("Error creating movie.");
        }
    }




    // Add more methods as needed
}
