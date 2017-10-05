package com.example.senamit.booklistingapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    private static final String LOG_TAG = BookLoader.class.getSimpleName();
    private String url = null;

    public BookLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
        if (url == null) {
            return null;
        }
        List<Book> bookList = null;
        try {
            bookList = QueryUtils.fetchBooksRequest(url);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "problem in loading Load In background data"+ e);
        }
        return bookList;
    }
}
