package com.example.senamit.booklistingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public String subject_name=null;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     final EditText search_box = (EditText)findViewById(R.id.search_box);
        Button btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             subject_name =  search_box.getText().toString();
                Log.i(LOG_TAG, "the search text is  "+ search_box.getText());
                intentFunction();
            }


        });
    }
    private void intentFunction(){
        Intent intent = new Intent(MainActivity.this, BooksList.class);
        intent.putExtra("search",subject_name);
        startActivity(intent);
    }
}
