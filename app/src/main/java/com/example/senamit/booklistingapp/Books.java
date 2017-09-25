package com.example.senamit.booklistingapp;

/**
 * Created by senamit on 25/9/17.
 */

public class Books {

    private String authors;
    private String title;

    public Books(String authors, String title) {
        this.authors = authors;
        this.title = title;
    }


    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }
}
