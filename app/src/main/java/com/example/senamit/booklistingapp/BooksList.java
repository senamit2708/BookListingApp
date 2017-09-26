package com.example.senamit.booklistingapp;

import android.net.Uri;
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
//    public static final String SAMPLE_JSON_URL = " https://www.googleapis.com/books/v1/volumes?q=android&maxResults=5";

    public static final String SAMPLE_JSON_URL = "https://www.googleapis.com/books/v1/volumes";

    BooksAdapter booksAdapter;
    final String QUERY_PARAM = "q";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

//        fun1();

//        MainActivity obj1 = new MainActivity();
//      String name = obj1.getSubject_name();
         String name= getIntent().getExtras().getString("search");


        Uri builtUri = Uri.parse(SAMPLE_JSON_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM,name ).build();

        Log.i(LOG_TAG,"the name is  "+ name);

        Log.i(LOG_TAG,"the uri is  "+builtUri.toString());

        BookSearchAsyncTask bookSearchAsyncTask = new BookSearchAsyncTask();
        bookSearchAsyncTask.execute(builtUri.toString());



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
