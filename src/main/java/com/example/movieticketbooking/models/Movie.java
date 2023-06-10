package com.example.movieticketbooking.models;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String language;
    private String durationMinutes;
    private String imageUrl;

    // Constructors, getters, setters, and other methods

    // Default constructor (required by JPA)
    public Movie() {
    }

    // Parameterized constructor
    public Movie(Long id, String name, String language, String durationMinutes, String imageUrl) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(String durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
