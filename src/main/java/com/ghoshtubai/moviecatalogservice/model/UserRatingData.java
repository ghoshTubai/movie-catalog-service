package com.ghoshtubai.moviecatalogservice.model;

import java.util.List;

public class UserRatingData {
    private String id;
    private List<Rating> rating;

    public UserRatingData() {
    }

    public UserRatingData(String id, List<Rating> rating) {
        this.id = id;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "UserRatingData{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                '}';
    }
}
