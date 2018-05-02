package com.example.komal.booklistingapp;

/**
 * Created by komal on 6/2/18.
 */

public class Book {
    private String mAuthor;
    private String mTitle;


    public Book(String Author, String Title) {
        mAuthor = Author;
        mTitle = Title;

    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }


}


