package com.example.senamit.booklistingapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class BookList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String LOG_TAG = BookList.class.getSimpleName();
    private static final String SAMPLE_JSON_URL = "https://www.googleapis.com/books/v1/volumes";
    final String QUERY_PARAM = "q";
    final String MAX_LIMIT = "maxResults";
    private Uri builtUri = null;
    private RecyclerView recyclerView;
    private BookCustomAdapter bookCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_book_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String name = getIntent().getExtras().getString("search2");
        builtUri = Uri.parse(SAMPLE_JSON_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, name)
                .appendQueryParameter(MAX_LIMIT, "10").build();

        Log.i(LOG_TAG, "the name is  " + name);
        Log.i(LOG_TAG, "the uri is  " + builtUri.toString());

        bookCustomAdapter = new BookCustomAdapter(new ArrayList<Book>());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bookCustomAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        return new BookLoader(this, builtUri.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> bookses) {
        BookCustomAdapter bookCustomAdapter1 = new BookCustomAdapter(bookses);
        recyclerView.setAdapter(bookCustomAdapter1);
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        bookCustomAdapter = new BookCustomAdapter(new ArrayList<Book>());
    }

}
