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
    public String getMovieById(@PathVariable("movieId") String movieId) {
        return "Fetching movie with ID: " + movieId;
    }

    @GetMapping("/movie/search/{movieName}")
    public String getMovieByName(@PathVariable("movieName") String movieName) {
        return "Searching for movie with name: " + movieName;
    }
}
