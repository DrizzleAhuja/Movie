package com.ncu.moviedetails.repository;

import com.ncu.moviedetails.model.MovieDetails;
import com.ncu.moviedetails.irepo.IMovieDetailsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class MovieDetailsRepositoryImpl implements IMovieDetailsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MovieDetails> getAllMovieDetails() {
        String sql = "SELECT * FROM moviedetails";
        return jdbcTemplate.query(sql, new MovieDetailsRowMapper());
    }

    @Override
    public MovieDetails getMovieDetailsById(String movieId) {
        String sql = "SELECT * FROM moviedetails WHERE movie_id = ?";
        return jdbcTemplate.queryForObject(sql, new MovieDetailsRowMapper(), movieId);
    }

    @Override
    public MovieDetails addMovieDetails(MovieDetails movieDetails) {
        String sql = "INSERT INTO moviedetails (movie_id, director, genre, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, movieDetails.getMovieId(), movieDetails.getDirector(), movieDetails.getGenre(), movieDetails.getDescription());
        return movieDetails;
    }
}
