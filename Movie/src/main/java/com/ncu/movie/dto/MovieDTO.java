package com.ncu.movie.dto;

import java.util.List;
import com.ncu.movie.dto.ReviewDTO;
import com.ncu.movie.dto.MovieDetailsDTO;
import com.ncu.movie.dto.TicketDTO;

public class MovieDTO {
    private String movieId;
    private String movieName;
    private int rating;
    private List<ReviewDTO> reviews;
    private MovieDetailsDTO movieDetails;
    private List<TicketDTO> tickets;

    public MovieDTO() {}

    public MovieDTO(String movieId, String movieName, int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
    }

    public MovieDTO(String movieId, String movieName, int rating, List<ReviewDTO> reviews) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.reviews = reviews;
    }

    public MovieDTO(String movieId, String movieName, int rating, List<ReviewDTO> reviews, MovieDetailsDTO movieDetails) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.reviews = reviews;
        this.movieDetails = movieDetails;
    }

    public MovieDTO(String movieId, String movieName, int rating, List<ReviewDTO> reviews, MovieDetailsDTO movieDetails, List<TicketDTO> tickets) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.reviews = reviews;
        this.movieDetails = movieDetails;
        this.tickets = tickets;
    }

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public MovieDetailsDTO getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(MovieDetailsDTO movieDetails) {
        this.movieDetails = movieDetails;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }
}
