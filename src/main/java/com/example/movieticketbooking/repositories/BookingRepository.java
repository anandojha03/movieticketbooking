package com.example.movieticketbooking.repositories;

import com.example.movieticketbooking.models.Booking;
import com.example.movieticketbooking.models.User;
import com.example.movieticketbooking.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    List<Booking> findByMovieId(Long movieId);


    // Add more methods as needed
}
