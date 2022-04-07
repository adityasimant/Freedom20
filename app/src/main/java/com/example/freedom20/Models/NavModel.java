package com.example.freedom20.Models;

public class NavModel {
    String name,email,profileUrl;


    public NavModel(String name, String email, String profileUrl) {
        this.name = name;
        this.email = email;
        this.profileUrl = profileUrl;
    }

    public NavModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
