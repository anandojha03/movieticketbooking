package com.example.movieticketbooking.controllers;

import com.example.movieticketbooking.models.SeatSelectionRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/seat_selection")
public class SeatSelectionController {

    private String movieId;
    private String date;
    private String showTiming;

    @GetMapping
    public String seatSelection(@RequestParam("movieId") String movieId, @RequestParam("movieName") String movieName, Model model) throws IOException {
        // Pass the movie ID and name to the frontend
        model.addAttribute("movieId", movieId);
        model.addAttribute("movieName", movieName);

        ClassPathResource resource = new ClassPathResource("static/frontend/seat_selection.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @PostMapping
    public ResponseEntity<?> postSeatSelection(@RequestBody SeatSelectionRequest request) {
        try {
            // Retrieve the data from the request
            movieId = request.getMovieId();
            date = request.getDate();
            showTiming = request.getShowTiming();

            // Process the data as needed

            // Return a response
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle any errors or exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
