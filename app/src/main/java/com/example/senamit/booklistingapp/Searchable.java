package com.example.senamit.booklistingapp;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;

public class Searchable extends AppCompatActivity implements SearchView.OnQueryTextListener{

    public static final String LOG_TAG =Searchable.class.getSimpleName();

   public  String result= null;

    TextView textCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

//
//        Intent intent = getIntent();
//        if (intent.ACTION_SEARCH.equals(intent.getAction())){
//
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            Log.i(LOG_TAG, "the query is  "+query);
//            doMySearch(query);
//        }
//        else
//        {
//            Log.i(LOG_TAG, "the query isin the else blcok  ");
//        }
//
//
//        Log.i(LOG_TAG, "The result is  "+result);
//
        SearchView searchView = (SearchView) findViewById(R.id.search_box);
        searchView.setOnQueryTextListener(this);

        textCheck = (TextView)findViewById(R.id.textcheck);

//


    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        Intent intent = getIntent();
//        if (intent.ACTION_SEARCH.equals(intent.getAction())){
//
//            String query1 = intent.getStringExtra(SearchManager.QUERY);
//            Log.i(LOG_TAG, "the query is  "+query1);
//            doMySearch(query);
//        }
//        else
//        {
//            Log.i(LOG_TAG, "the query isin the else blcok  ");

//        }
        result=query;
        Log.i(LOG_TAG, "inside onquerytextsubmit  " + query);
        intentStarter();
        Log.i(LOG_TAG, "Yes I am back  ha ha");
        return true;
    }

    private void intentStarter() {
        Intent intent = new Intent(Searchable.this, BooksList.class);
        Log.i(LOG_TAG, "intent starter   "+result);
        intent.putExtra("search2", result);
        startActivity(intent);



    }

    @Override
    public boolean onQueryTextChange(String newText) {

        Log.i(LOG_TAG, "inside onquerytextschange  "+ newText);
        return false;
    }
}
