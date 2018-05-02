package com.example.komal.booklistingapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    BookAdapter mAdapter;
    ListView listView;

    static final String SEARCH_RESULTS = "booksSearchResults";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text_view);
        Button btn = (Button) findViewById(R.id.searchBtn);
        mAdapter=new BookAdapter(this, -1);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(mAdapter);
         final String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=search+";





        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String formatUserInput = getUserInput().trim().replaceAll("\\s+","+");
                String url = baseUrl + formatUserInput;
                BookAsyncTask task = new BookAsyncTask();
                task.execute(url);

            }
        });

        if (savedInstanceState != null) {
            Book[] books = (Book[]) savedInstanceState.getParcelableArray(SEARCH_RESULTS);
            mAdapter.addAll(books);
        }


    }
    private String getUserInput() {
        return editText.getText().toString();
    }



    private void updateUi(List<Book> books) {

        mAdapter.clear();
        mAdapter.addAll(books);
    }


   private  class BookAsyncTask extends AsyncTask<String, Void, List<Book>> {
        @Override
        protected List<Book> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null)
                return null;
            List<Book> result = QueryUtils.fetchBookData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Book> data) {
            if (data == null) {
                return;
            }
            updateUi(data);
        }
    }
}




