package com.example.senamit.booklistingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by senamit on 25/9/17.
 */

public class BooksAdapter extends ArrayAdapter<Books> {



    public BooksAdapter(Context context, ArrayList<Books> booksArrayList){
        super(context, 0, booksArrayList);

    };


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        View listItemView = convertView;
        if (listItemView ==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_books_items,parent, false );

        }

        Books books = getItem(position);

        TextView txt_author = (TextView)listItemView.findViewById(R.id.txt_author);
        txt_author.setText(books.getAuthors());

        TextView txt_title = (TextView)listItemView.findViewById(R.id.txt_title);
        txt_title.setText(books.getTitle());





        return listItemView;
    }
}
