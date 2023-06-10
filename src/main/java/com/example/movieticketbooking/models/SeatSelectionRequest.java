package com.example.movieticketbooking.models;

public class SeatSelectionRequest {
    private String movie;
    private String date;
    private String showTiming;

    public SeatSelectionRequest() {
    }

    public SeatSelectionRequest(String movieId, String date, String showTiming) {
        this.movie = movieId;
        this.date = date;
        this.showTiming = showTiming;
    }

    public String getMovieId() {
        return movie;
    }

    public void setMovieId(String movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }

    // Constructors, getters, and setters
}
