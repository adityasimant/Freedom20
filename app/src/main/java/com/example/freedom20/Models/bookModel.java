package com.example.freedom20.Models;

import com.squareup.picasso.RequestCreator;

public class bookModel {
    String book,Title,author,link;


    public bookModel(String book, String title, String author, String link) {
        this.book = book;
        this.Title = title;
        this.author = author;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
