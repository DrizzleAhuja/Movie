package com.ncu.moviedetails.Services;

import com.ncu.moviedetails.model.MovieDetails;
import com.ncu.moviedetails.dto.MovieDetailsDTO;
import com.ncu.moviedetails.irepo.IMovieDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieDetailsService {
    @Autowired
    private IMovieDetailsRepository movieDetailsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDetailsDTO> getAllMovieDetails() {
        List<MovieDetails> movieDetailsList = movieDetailsRepository.getAllMovieDetails();
        return movieDetailsList.stream()
                .map(md -> modelMapper.map(md, MovieDetailsDTO.class))
                .collect(Collectors.toList());
    }

    public MovieDetailsDTO getMovieDetailsById(String movieId) {
        MovieDetails movieDetails = movieDetailsRepository.getMovieDetailsById(movieId);
        if (movieDetails == null) {
            return null;
        }
        return modelMapper.map(movieDetails, MovieDetailsDTO.class);
    }

    public MovieDetailsDTO addMovieDetails(MovieDetailsDTO movieDetailsDTO) {
        MovieDetails movieDetails = modelMapper.map(movieDetailsDTO, MovieDetails.class);
        // Assuming movieId is provided in the DTO or generated elsewhere if not.
        // For simplicity, we'll use the provided movieId or generate a placeholder.
        if (movieDetails.getMovieId() == null || movieDetails.getMovieId().isEmpty()) {
            movieDetails.setMovieId("MD" + System.currentTimeMillis());
        }
        movieDetailsRepository.addMovieDetails(movieDetails);
        return modelMapper.map(movieDetails, MovieDetailsDTO.class);
    }
}
