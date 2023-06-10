package com.example.movieticketbooking.models;

import java.time.LocalDate;
import java.util.List;

public class BookingData {
    private double totalPrice;
    private List<String> selectedSeats;
    private String movieId;
    private String movieName;
    private LocalDate dateTime;
    private int showTime;
    private Long userId;

    public BookingData() {
    }

    public BookingData(double totalPrice, List<String> selectedSeats, String movieId, String movieName, LocalDate dateTime, int showTime, Long userId) {
        this.totalPrice = totalPrice;
        this.selectedSeats = selectedSeats;
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
