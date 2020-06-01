package com.ghoshtubai.moviecatalogservice.model;

public class CatalogService {
    private String name;
    private String description;
    private Integer rating;
    private String genre;
    private String releaseDate;

    public CatalogService() {
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

    public CatalogService(String name, String description, Integer rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public CatalogService(String name, String description, Integer rating, String genre, String releaseDate) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
