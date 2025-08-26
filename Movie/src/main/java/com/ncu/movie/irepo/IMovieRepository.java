package com.ncu.movie.irepo;

import com.ncu.movie.model.Movie;
import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    Movie getMovieById(String movieId);
    Movie addMovie(Movie movie);
}
