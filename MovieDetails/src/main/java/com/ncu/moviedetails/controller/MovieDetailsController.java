package com.ncu.moviedetails.controller;

import com.ncu.moviedetails.dto.MovieDetailsDTO;
import com.ncu.moviedetails.Services.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviedetails")
public class MovieDetailsController {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @GetMapping
    public List<MovieDetailsDTO> getAllMovieDetails() {
        return movieDetailsService.getAllMovieDetails();
    }

    @GetMapping("/{movieId}")
    public MovieDetailsDTO getMovieDetailsById(@PathVariable String movieId) {
        return movieDetailsService.getMovieDetailsById(movieId);
    }

    @PostMapping
    public String addMovieDetails(@RequestBody MovieDetailsDTO movieDetailsDTO) {
        movieDetailsService.addMovieDetails(movieDetailsDTO);
        return "Movie details added to DB!";
    }
}
