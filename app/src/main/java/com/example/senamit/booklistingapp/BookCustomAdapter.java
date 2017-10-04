package com.example.senamit.booklistingapp;

import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by senamit on 5/10/17.
 */

public class BookCustomAdapter extends RecyclerView.Adapter<BookCustomAdapter.ViewHolder>{

    List<Books> bookList;

    public BookCustomAdapter(List<Books> bookList) {

        this.bookList = bookList;
    }

    @Override
    public BookCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_books_items, parent, false);
       return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(BookCustomAdapter.ViewHolder holder, int position) {



        holder.imageView.setImageBitmap(bookList.get(position).getBitmap());

        holder.author_name.setText(bookList.get(position).getAuthors());
        holder.title.setText(bookList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView author_name;
        TextView title;



        public ViewHolder(View itemView) {
            super(itemView);

            imageView= (ImageView)itemView.findViewById(R.id.image);
            author_name = (TextView)itemView.findViewById(R.id.txt_author);
            title= (TextView)itemView.findViewById(R.id.txt_title);
        }
    }
}
