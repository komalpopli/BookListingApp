package com.example.komal.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.komal.booklistingapp.Book;
import com.example.komal.booklistingapp.R;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, int resource) {
        super(context, resource);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Book currentBook = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.bookTitleTextView);
        title.setText(currentBook.getTitle());

        TextView author= (TextView) listItemView.findViewById(R.id.bookAuthorTextView);
        author.setText(currentBook.getAuthor());

        return listItemView;
    }
}
