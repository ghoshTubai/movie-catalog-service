package com.ghoshtubai.moviecatalogservice.model;

import java.util.List;

public class UserProduct {
    private Integer id;
    private String username;
    private List<String> phoneNumber;

    public UserProduct() {
    }

    public UserProduct(Integer id, String username, List<String> phoneNumber) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserProduct(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
