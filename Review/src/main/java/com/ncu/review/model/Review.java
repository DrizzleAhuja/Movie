package com.ncu.review.model;

public class Review {
    private String reviewId;
    private String movieId;
    private String reviewText;
    private int rating;

    public Review() {}

    public Review(String reviewId, String movieId, String reviewText, int rating) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getReviewId() { return reviewId; }
    public void setReviewId(String reviewId) { this.reviewId = reviewId; }
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
