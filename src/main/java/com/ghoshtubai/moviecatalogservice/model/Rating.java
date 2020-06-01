package com.ghoshtubai.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class Rating {
    private String movieName;
    private int rating;

    public Rating() {
    }
    public Rating(String movieName, int rating) {
        this.movieName = movieName;
        this.rating = rating;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
