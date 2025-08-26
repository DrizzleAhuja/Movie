package com.ncu.movie.repository;

import com.ncu.movie.model.Movie;
import com.ncu.movie.irepo.IMovieRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements IMovieRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public Movie getMovieById(String movieId) {
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        return jdbcTemplate.queryForObject(sql, new MovieRowMapper(), movieId);
    }

    @Override
    public Movie addMovie(Movie movie) {
        String sql = "INSERT INTO movie (movie_id, movie_name, rating) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, movie.getMovieId(), movie.getMovieName(), movie.getRating());
        return movie;
    }
}
