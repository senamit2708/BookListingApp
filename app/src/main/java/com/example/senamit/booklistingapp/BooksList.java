package com.example.senamit.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class BooksList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        String[] booksName = {"book1","book2","book3","book4","book5"};


        ListView listView = (ListView) (findViewById(R.id.list_item));

        ArrayAdapter arrayAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,booksName );

        listView.setAdapter(arrayAdapter);
    }
}
