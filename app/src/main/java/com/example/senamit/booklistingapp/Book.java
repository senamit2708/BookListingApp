package com.example.senamit.booklistingapp;

import android.graphics.Bitmap;

public class Book {

    private String authors;
    private String title;
    private String url;
    private Bitmap bitmap;

    public Book(String authors, String title, String url, Bitmap bitmap) {
        this.authors = authors;
        this.title = title;
        this.url = url;
        this.bitmap = bitmap;
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

    public Bitmap getBitmap() {
        return bitmap;
    }
}
