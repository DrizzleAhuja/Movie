package com.ncu.movie.Services;

import com.ncu.movie.model.Movie;
import com.ncu.movie.dto.MovieDTO;
import com.ncu.movie.irepo.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.getAllMovies();
        return movies.stream()
            .map(m -> modelMapper.map(m, MovieDTO.class))
            .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(String movieId) {
        Movie movie = movieRepository.getMovieById(movieId);
        return modelMapper.map(movie, MovieDTO.class);
    }

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        movie.setMovieId("M" + System.currentTimeMillis());
        movieRepository.addMovie(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }
}
