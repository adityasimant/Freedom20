package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freedom20.Adapter.LogsAdapter;
import com.example.freedom20.Adapter.bookAdapter;
import com.example.freedom20.Models.LogsModel;
import com.example.freedom20.Models.bookModel;
import com.example.freedom20.R;

import java.util.ArrayList;

public class QnAFragment extends Fragment {

    RecyclerView BooksRV,books1,books2;
    ArrayList<LogsModel> booksList;
    ArrayList<bookModel> books1list;
    ArrayList<bookModel> books2list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qn_a, container, false);

        books1 = view.findViewById(R.id.books1);
        books2 = view.findViewById(R.id.books2);
        booksList = new ArrayList<>();
        books1list = new ArrayList<>();
        books2list = new ArrayList<>();



        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books1list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));

        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));
        books2list.add(new bookModel(R.drawable.booksimg,"another book","adi","link"));


        booksList.add(new LogsModel(R.drawable.stockimg,"Stock Market","Learn with Zerodha Varsity","Investing is an important way to build wealth and save for the future.\n" +
                "Here’s what we should have learned about the stock market."));

        booksList.add(new LogsModel(R.drawable.algorithm,"Algorithms","Learn With Standford online","Divide and Conquer,\n" +
                "Sorting and Searching, and Randomized Algorithms"));

        booksList.add(new LogsModel(R.drawable.react,"ReactJS","Learn With Scrimba","The ultimate React 101 - the perfect starting\n" +
                "point for any React beginner"));



        BooksRV = view.findViewById(R.id.BooksRv);
        LogsAdapter adapter = new LogsAdapter(booksList,getContext());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        BooksRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        BooksRV.setNestedScrollingEnabled(false);
        BooksRV.setHasFixedSize(true);
        BooksRV.setAdapter(adapter);


        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        bookAdapter adapter1 = new bookAdapter(getContext(),books1list);
        books1.setAdapter(adapter1);
        books1.setHasFixedSize(false);
        books1.setLayoutManager(layoutManager1);

  LinearLayoutManager layoutManager2
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        bookAdapter adapter2 = new bookAdapter(getContext(),books2list);
        books1.setAdapter(adapter2);
        books1.setHasFixedSize(false);
        books1.setLayoutManager(layoutManager2);

        return view;
    }
}