package com.example.senamit.booklistingapp;

import android.graphics.Bitmap;


/**
 * Created by senamit on 25/9/17.
 */

public class Books {

    private String authors;
    private String title;
    private String url;
    private Bitmap bitmap;


    public Books(String authors, String title, String url, Bitmap bitmap) {
        this.authors = authors;
        this.title = title;
        this.url = url;
        this.bitmap=bitmap;
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

    public Bitmap getBitmap() {return bitmap;}
}
