package com.ncu.moviedetails.model;

public class MovieDetails {
    private String movieId;
    private String director;
    private String genre;
    private String description;

    public MovieDetails() {}

    public MovieDetails(String movieId, String director, String genre, String description) {
        this.movieId = movieId;
        this.director = director;
        this.genre = genre;
        this.description = description;
    }

    // Getters and Setters
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
