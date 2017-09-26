package com.example.senamit.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class BooksList extends AppCompatActivity {

//    public static final String SAMPLE_JSON_RESPONSE = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

//        String[] booksName = {"book1","book2","book3","book4","book5"};







//        ArrayList<Books> booksArrayList = new ArrayList<Books>();

        ArrayList<Books> booksArrayList = null;
        try {
            booksArrayList = QueryUtils.extractFeatureFromJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }


//
//        booksArrayList.add(new Books("Amit","Life is fun "));
//        booksArrayList.add(new Books("Vikash","My life my rules"));
//        booksArrayList.add(new Books("Rakesh","Dont angry me"));
//        booksArrayList.add(new Books("Ashok","Live life as king"));
//        booksArrayList.add(new Books("pretam","Life is great"));
//        booksArrayList.add(new Books("mohan","My life dont know"));
//        booksArrayList.add(new Books("agnish","Dont angry  someone"));
//        booksArrayList.add(new Books("PPDA","Live life is hell"));



        BooksAdapter booksAdapter = new BooksAdapter(getBaseContext(), booksArrayList);



        ListView listView = (ListView) (findViewById(R.id.list_item));

//        ArrayAdapter arrayAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,booksName );

        listView.setAdapter(booksAdapter);
    }
}
