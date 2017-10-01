package com.example.senamit.booklistingapp;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import org.json.JSONException;
import java.util.ArrayList;



public class BooksList extends AppCompatActivity {

    public static final String LOG_TAG = BooksList.class.getSimpleName();
    public static final String SAMPLE_JSON_URL = "https://www.googleapis.com/books/v1/volumes";
    BooksAdapter booksAdapter;
    final String QUERY_PARAM = "q";
    final String MAX_LIMIT ="maxResults";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);


      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         String name= getIntent().getExtras().getString("search");


        Uri builtUri = Uri.parse(SAMPLE_JSON_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM,name )
                .appendQueryParameter(MAX_LIMIT, "2").build();

        Log.i(LOG_TAG,"the name is  "+ name);

        Log.i(LOG_TAG,"the uri is  "+builtUri.toString());

        BookSearchAsyncTask bookSearchAsyncTask = new BookSearchAsyncTask();
        bookSearchAsyncTask.execute(builtUri.toString());
        booksAdapter = new BooksAdapter(getBaseContext(), new ArrayList<Books>());
        ListView listView = (ListView) (findViewById(R.id.list_item));
        listView.setAdapter(booksAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Books selectedBook = booksAdapter.getItem(i);
                Uri bookUri = Uri.parse(selectedBook.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookUri);
                startActivity(websiteIntent);
            }
        });
    }

    private class BookSearchAsyncTask extends AsyncTask<String, Void, ArrayList<Books>>{
        @Override
        protected ArrayList<Books> doInBackground(String... url) {

            Log.i(LOG_TAG, "Inside doInBackground method");

            if (url.length<1 || url[0]==null){
                return null;
            }
            ArrayList<Books> booksArrayList=null;
            try {
                booksArrayList = QueryUtils.fetchBooksRequest(url[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i(LOG_TAG, "Books array list doInBackground method  "+booksArrayList);
            return booksArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<Books> booksArrayList) {
            booksAdapter.clear();
            booksAdapter.addAll(booksArrayList);

        }
    }

}
