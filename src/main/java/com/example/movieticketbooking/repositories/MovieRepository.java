package com.example.movieticketbooking.repositories;

import com.example.movieticketbooking.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByLanguage(String language);

    List<Movie> findByName(String name);

    Optional<Movie> findById(Long id);

    // Other methods...
}

