package com.example.movieticketbooking.services;

import com.example.movieticketbooking.models.Booking;
import com.example.movieticketbooking.models.Movie;
import com.example.movieticketbooking.models.User;
import com.example.movieticketbooking.repositories.BookingRepository;
import com.example.movieticketbooking.repositories.MovieRepository;
import com.example.movieticketbooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository,
                           UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;

        this.userRepository = userRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public Booking createBooking(Booking booking) {

        bookingRepository.save(booking);

        return booking;
    }


    public List<Booking> getBookingsByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByMovie(Long movieId){
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if(movie == null){
            return null;
        }

        return bookingRepository.findByMovieId(movieId);
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking != null) {
            bookingRepository.delete(booking);
        }
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
