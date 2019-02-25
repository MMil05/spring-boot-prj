package com.infoshare.test.controller;

import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.service.MovieInsertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;
    private final MovieInsertService insertService;

    public MovieController(MovieRepository repository, MovieInsertService insertService) {
        this.repository = repository;
        this.insertService = insertService;
    }


    @GetMapping
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Movie> AddNew(@RequestBody Movie movie) {
        Movie addedMovie = insertService.addNewMovie(movie);
        return ResponseEntity.ok(addedMovie);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getById(@PathVariable Long movieId) {

      /*  Optional<Movie> movie = repository.findById(movieId);
        if (movie.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(movie.get());
        } else{
            return ResponseEntity.notFound().build();
        }*/
        return repository.findById(movieId)
                .map(body -> ResponseEntity.ok(body))  // = .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Movie> findByCategory(@RequestParam Category category) {
        return repository.findAllByCategory(category);

    }
}
