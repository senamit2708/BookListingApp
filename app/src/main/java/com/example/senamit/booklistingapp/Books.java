package com.example.senamit.booklistingapp;

import android.widget.ImageView;

/**
 * Created by senamit on 25/9/17.
 */

public class Books {

    private String authors;
    private String title;
    private String url;


    public Books(String authors, String title, String url) {
        this.authors = authors;
        this.title = title;
        this.url = url;

    }


    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }
}
