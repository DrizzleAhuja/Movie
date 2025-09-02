package com.ncu.moviedetails.repository;

import com.ncu.moviedetails.model.MovieDetails;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDetailsRowMapper implements RowMapper<MovieDetails> {
    @Override
    public MovieDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovieId(rs.getString("movie_id"));
        movieDetails.setDirector(rs.getString("director"));
        movieDetails.setGenre(rs.getString("genre"));
        movieDetails.setDescription(rs.getString("description"));
        return movieDetails;
    }
}
