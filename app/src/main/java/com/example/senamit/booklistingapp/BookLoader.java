package com.example.senamit.booklistingapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Books>> {

    public static final String LOG_TAG = BookLoader.class.getSimpleName();
    public String url = null;

    public BookLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Books> loadInBackground() {
        Log.e(LOG_TAG, "indisde on load in background");
        if (url == null) {
            return null;
        }
        List<Books> booksList = null;
        try {
            booksList = QueryUtils.fetchBooksRequest(url);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "problem in loading Load In background data");
        }
        return booksList;
    }
}
