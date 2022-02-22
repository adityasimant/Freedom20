package com.example.freedom20.Models;

public class Dashboard {

    int profile;
    String post,name,bio,like,comment, share;

    public Dashboard(int profile, String post, String name, String bio, String like, String comment, String share) {
        this.profile = profile;
        this.post = post;
        this.name = name;
        this.bio = bio;
        this.like = like;
        this.comment = comment;
//        this.share = share;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
