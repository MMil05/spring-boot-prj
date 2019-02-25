package com.infoshare.test;

import com.infoshare.test.model.Category;
import com.infoshare.test.model.Director;
import com.infoshare.test.model.Movie;
import com.infoshare.test.model.Rating;
import com.infoshare.test.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        getMovie1();
    }

    private void getMovie1() {
        Director director = new Director();
        director.setFirstName("Francis");
        director.setLastName("Coppola");
        Rating rating = new Rating();
        rating.setScore(9);
        Movie movie = new Movie("3-598-21500-2", "The Godfather", 1972, Category.CRIME, director, rating, 175);

        Director director1 = new Director();
        director1.setFirstName("Stanley");
        director1.setLastName("Kubrick");
        Rating rating1 = new Rating();
        rating1.setScore(8);
        Movie movie1 = new Movie("3-598-21560-6", " 2001: A Space Odyssey", 1968, Category.SCI_FI, director1, rating1, 149);

        movieRepository.save(movie);
        movieRepository.save(movie1);
    }
}
