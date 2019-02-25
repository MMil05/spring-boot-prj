package com.infoshare.test.service;

import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInsertService {

    private final MovieValidator movieValidator;
    private final MovieIdGeneratorService movieIdGeneratorService;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieInsertService(MovieValidator movieValidator, MovieIdGeneratorService movieIdGeneratorService, MovieRepository movieRepository) {
        this.movieValidator = movieValidator;
        this.movieIdGeneratorService = movieIdGeneratorService;
        this.movieRepository = movieRepository;
    }

    public Movie addNewMovie(Movie movie) {
        //    movie.setId(movieIdGeneratorService.generateId());
        //    movieValidator.validateMovie(movie);
        return movieRepository.save(movie);
    }

}