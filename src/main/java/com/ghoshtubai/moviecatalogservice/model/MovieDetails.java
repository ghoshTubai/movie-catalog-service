package com.ghoshtubai.moviecatalogservice.model;

public class MovieDetails {

    private String description;
    private String genre;
    private String releaseDate;

    public MovieDetails() {
    }

    public MovieDetails(String description, String genre, String releaseDate) {
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
