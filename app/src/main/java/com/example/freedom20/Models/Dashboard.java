package com.example.freedom20.Models;

public class Dashboard {
    private String PostId;
    private String PostImg;
    private String PostedBy;
    private String Hpost;
    private String Mpost;
    private long PostedAt;

    public Dashboard(String postId, String postImg, String postedBy, String hpost, String mpost, long postedAt) {
        PostId = postId;
        PostImg = postImg;
        PostedBy = postedBy;
        Hpost = hpost;
        Mpost = mpost;
        PostedAt = postedAt;
    }

    public Dashboard() {
    }

    public String getPostId() {
        return PostId;
    }

    public void setPostId(String postId) {
        PostId = postId;
    }

    public String getPostImg() {
        return PostImg;
    }

    public void setPostImg(String postImg) {
        PostImg = postImg;
    }

    public String getPostedBy() {
        return PostedBy;
    }

    public void setPostedBy(String postedBy) {
        PostedBy = postedBy;
    }

    public String getHpost() {
        return Hpost;
    }

    public void setHpost(String hpost) {
        Hpost = hpost;
    }

    public String getMpost() {
        return Mpost;
    }

    public void setMpost(String mpost) {
        Mpost = mpost;
    }

    public long getPostedAt() {
        return PostedAt;
    }

    public void setPostedAt(long postedAt) {
        PostedAt = postedAt;
    }
}
