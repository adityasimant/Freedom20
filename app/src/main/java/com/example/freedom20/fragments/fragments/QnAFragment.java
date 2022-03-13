package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.freedom20.Adapter.BooksAdapter;
import com.example.freedom20.Models.BooksModel;
import com.example.freedom20.R;
import com.example.freedom20.zerodha_Fragment;

import java.util.ArrayList;

public class QnAFragment extends Fragment {

    RecyclerView BooksRV;
    ArrayList<BooksModel> booksList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qn_a, container, false);

        BooksRV = view.findViewById(R.id.BooksRv);
        booksList = new ArrayList<>();

        booksList.add(new BooksModel(R.drawable.stockimg,"Stock Market","Learn with Zerodha Varsity","Investing is an important way to build wealth and save for the future.\n" +
                "Here’s what we should have learned about the stock market."));

        booksList.add(new BooksModel(R.drawable.algorithm,"Algorithms","Learn With Standford online","Divide and Conquer,\n" +
                "Sorting and Searching, and Randomized Algorithms"));
        booksList.add(new BooksModel(R.drawable.react,"ReactJS","Learn With Scrimba","The ultimate React 101 - the perfect starting\n" +
                "point for any React beginner"));

        BooksAdapter adapter = new BooksAdapter(booksList,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        BooksRV.setLayoutManager(layoutManager);
        BooksRV.setNestedScrollingEnabled(false);
        BooksRV.setAdapter(adapter);
        return view;
    }
}