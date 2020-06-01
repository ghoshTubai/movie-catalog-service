package com.ghoshtubai.moviecatalogservice.model;


public class MovieInfo {
    private String movieId;
    private MovieDetails details;

    public MovieInfo(String movieId, MovieDetails details) {
        this.movieId = movieId;
        this.details = details;
    }

    public MovieInfo() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public MovieDetails getDetails() {
        return details;
    }

    public void setDetails(MovieDetails details) {
        this.details = details;
    }
}
