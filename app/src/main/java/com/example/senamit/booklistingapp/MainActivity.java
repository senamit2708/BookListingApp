package com.example.senamit.booklistingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!CheckNetwork.isInternetAvailable(getApplicationContext())) {
            AlertDialogSettingFragment alertDialogSettingFragment = new AlertDialogSettingFragment();
            alertDialogSettingFragment.show(getSupportFragmentManager(), "Alert Dialog");
        }
        SearchView searchView = (SearchView) findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(MainActivity.this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        result = query;
        intentStarter();
        return true;
    }

    private void intentStarter() {
        Intent intent = new Intent(MainActivity.this, BooksList.class);
        intent.putExtra("search2", result);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}

