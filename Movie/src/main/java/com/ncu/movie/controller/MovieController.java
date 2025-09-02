package com.ncu.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.ncu.movie.dto.MovieDTO;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private com.ncu.movie.Services.MovieService movieService;

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public String addMovie(@RequestBody MovieDTO movieDTO) {
        movieService.addMovie(movieDTO);
        return "Movie added to DB!";
    }

    @GetMapping("/movie/{movieId}")
    public MovieDTO getMovieById(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/movie/search/{movieName}")
    public List<MovieDTO> getMovieByName(@PathVariable("movieName") String movieName) {
        // You will need to implement a getMovieByName method in your MovieService
        // For now, returning an empty list or handling as per your service logic
        return movieService.getAllMovies().stream()
                .filter(movie -> movie.getMovieName().equalsIgnoreCase(movieName))
                .collect(Collectors.toList());
    }
}
