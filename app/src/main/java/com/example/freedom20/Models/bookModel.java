package com.example.freedom20.Models;

public class bookModel {
    int book;
    String Title,author,link;


    public bookModel(int book, String title, String author, String link) {
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



    public int getBook() {
        return book;
    }

    public void setBook(int book) {
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
