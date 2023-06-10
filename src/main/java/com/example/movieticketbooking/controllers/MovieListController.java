package com.example.movieticketbooking.controllers;

import com.example.movieticketbooking.models.Movie;
import com.example.movieticketbooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all_movies")
public class MovieListController {

    private final MovieService movieService;

    @Autowired
    public MovieListController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
