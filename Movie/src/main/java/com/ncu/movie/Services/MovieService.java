package com.ncu.movie.Services;

import com.ncu.movie.model.Movie;
import com.ncu.movie.dto.MovieDTO;
import com.ncu.movie.dto.ReviewDTO;
import com.ncu.movie.dto.MovieDetailsDTO;
import com.ncu.movie.dto.TicketDTO;
import com.ncu.movie.irepo.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    private final RestClient reviewRestClient;
    private final RestClient movieDetailsRestClient;
    private final RestClient ticketRestClient;

    public MovieService(RestClient.Builder restClientBuilder) {
        this.reviewRestClient = restClientBuilder.baseUrl("http://REVIEWSYSTEM").build(); // Using Eureka service name
        this.movieDetailsRestClient = restClientBuilder.baseUrl("http://MovieDetailsSystem").build(); // Using Eureka service name
        this.ticketRestClient = restClientBuilder.baseUrl("http://TICKETSERVICE").build(); // Using Eureka service name
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.getAllMovies();
        return movies.stream()
            .map(m -> {
                MovieDTO movieDTO = modelMapper.map(m, MovieDTO.class);
                movieDTO.setReviews(getReviewsByMovieId(m.getMovieId()));
                movieDTO.setMovieDetails(getMovieDetails(m.getMovieId())); // Fetch movie details
                movieDTO.setTickets(getTicketsByMovieId(m.getMovieId())); // Fetch tickets
                return movieDTO;
            })
            .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(String movieId) {
        Movie movie = movieRepository.getMovieById(movieId);
        if (movie == null) {
            return null;
        }
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        movieDTO.setReviews(getReviewsByMovieId(movieId));
        movieDTO.setMovieDetails(getMovieDetails(movieId)); // Fetch movie details
        movieDTO.setTickets(getTicketsByMovieId(movieId)); // Fetch tickets
        return movieDTO;
    }

    private List<ReviewDTO> getReviewsByMovieId(String movieId) {
        try {
            ReviewDTO[] reviews = reviewRestClient.get()
                    .uri("/reviews/movie/{movieId}", movieId)
                    .retrieve()
                    .body(ReviewDTO[].class);
            return Arrays.asList(reviews);
        } catch (Exception e) {
            System.err.println("Error fetching reviews for movieId " + movieId + ": " + e.getMessage());
            return List.of(); // Return empty list on error
        }
    }

    private MovieDetailsDTO getMovieDetails(String movieId) {
        try {
            return movieDetailsRestClient.get()
                    .uri("/moviedetails/{movieId}", movieId)
                    .retrieve()
                    .body(MovieDetailsDTO.class);
        } catch (Exception e) {
            System.err.println("Error fetching movie details for movieId " + movieId + ": " + e.getMessage());
            return null; // Return null or a default MovieDetailsDTO on error
        }
    }

    private List<TicketDTO> getTicketsByMovieId(String movieId) {
        try {
            TicketDTO[] tickets = ticketRestClient.get()
                    .uri("/tickets/movie/{movieId}", movieId)
                    .retrieve()
                    .body(TicketDTO[].class);
            return Arrays.asList(tickets);
        } catch (Exception e) {
            System.err.println("Error fetching tickets for movieId " + movieId + ": " + e.getMessage());
            return List.of(); // Return empty list on error
        }
    }

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        movie.setMovieId("M" + System.currentTimeMillis());
        movieRepository.addMovie(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }
}
