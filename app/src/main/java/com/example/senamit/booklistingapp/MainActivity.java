package com.example.senamit.booklistingapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public String subject_name=null;
    public EditText search_box= null;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!CheckNetwork.isInternetAvailable(getApplicationContext())){

//            Toast.makeText(MainActivity.this, "Internet Connection not available", Toast.LENGTH_SHORT).show();
            AlertDialogSettingFragment alertDialogSettingFragment= new AlertDialogSettingFragment();
            alertDialogSettingFragment.show(getSupportFragmentManager(), "Alert Dialog");

            Log.i(LOG_TAG, "inside dialog box"); }

        search_box= (EditText)findViewById(R.id.search_box);

        search_box.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if ((keyEvent.getAction()==keyEvent.ACTION_DOWN) && (keyCode == keyEvent.KEYCODE_ENTER) ){

                    subject_name =  search_box.getText().toString();
                    Log.e(LOG_TAG, "checking the value on enter   "+subject_name);
                    InputSubjectCheck();
                    return true;
                }
                return false;
            }
        });
        // for some time only ...only for trail purpose

        Button btn_searchable = (Button)findViewById(R.id.btn_searchable);
        btn_searchable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Searchable.class);
                startActivity(intent);

            }
        });


        Button btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                subject_name =  search_box.getText().toString();
                Log.e(LOG_TAG, "checking the value on search   "+subject_name);
                InputSubjectCheck();
                search_box.setText("");
            }
        });
    }

    private void InputSubjectCheck() {

        if (TextUtils.isEmpty(subject_name)){
            search_box.setError("Please enter subject name");
        }
        else {
            Log.i(LOG_TAG, "the search text is  "+ search_box.getText());
            intentFunction();
        }
    }

    private void intentFunction(){
        Intent intent = new Intent(MainActivity.this, BooksList.class);
        intent.putExtra("search",subject_name);
        startActivity(intent);
    }
}
