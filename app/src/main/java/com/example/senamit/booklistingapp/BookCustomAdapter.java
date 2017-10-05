package com.example.senamit.booklistingapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class BookCustomAdapter extends RecyclerView.Adapter<BookCustomAdapter.ViewHolder> {

    List<Books> bookList;
    Context context;

    public static final String LOG_TAG = BookCustomAdapter.class.getSimpleName();

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
        final Uri link = Uri.parse(bookList.get(position).getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, link);
                context.startActivity(websiteIntent);
            }
        });
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
            imageView = (ImageView) itemView.findViewById(R.id.image);
            author_name = (TextView) itemView.findViewById(R.id.txt_author);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            context = itemView.getContext();
        }
    }
}
