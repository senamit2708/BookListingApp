package com.example.senamit.booklistingapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;

import java.util.ArrayList;



public class BooksList extends AppCompatActivity {

    public static final String LOG_TAG = BooksList.class.getSimpleName();
//    public static final String SAMPLE_JSON_RESPONSE = null;
    public static final String SAMPLE_JSON_URL = " https://www.googleapis.com/books/v1/volumes?q=android&maxResults=5";

    BooksAdapter booksAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);


        BookSearchAsyncTask bookSearchAsyncTask = new BookSearchAsyncTask();
        bookSearchAsyncTask.execute(SAMPLE_JSON_URL);



        booksAdapter = new BooksAdapter(getBaseContext(), new ArrayList<Books>());



        ListView listView = (ListView) (findViewById(R.id.list_item));



        listView.setAdapter(booksAdapter);
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
