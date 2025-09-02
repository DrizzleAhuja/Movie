package com.ncu.moviedetails.irepo;

import com.ncu.moviedetails.model.MovieDetails;
import java.util.List;

public interface IMovieDetailsRepository {
    List<MovieDetails> getAllMovieDetails();
    MovieDetails getMovieDetailsById(String movieId);
    MovieDetails addMovieDetails(MovieDetails movieDetails);
}
