package com.example.movieticketbooking.services;

import com.example.movieticketbooking.models.Movie;
import com.example.movieticketbooking.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    public Movie updateMovie(Long movieId, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setName(updatedMovie.getName());
            movie.setLanguage(updatedMovie.getLanguage());
            movie.setDurationMinutes(updatedMovie.getDurationMinutes());
            return movieRepository.save(movie);
        }
        throw new RuntimeException("Movie not found with ID: " + movieId);
    }
}
