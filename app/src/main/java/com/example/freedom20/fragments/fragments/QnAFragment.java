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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QnAFragment extends Fragment {

    RecyclerView BooksRV,books1,books2;
    ArrayList<LogsModel> booksList;
    ArrayList<bookModel> books1list;
    ArrayList<bookModel> books2list;

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseStorage storage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qn_a, container, false);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        books1 = view.findViewById(R.id.books1);
        books2 = view.findViewById(R.id.books2);
        booksList = new ArrayList<>();
        books1list = new ArrayList<>();
        books2list = new ArrayList<>();

        books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2FRchDadPoorDad.png?alt=media&token=ebe69f5e-aa0f-4723-8cb6-1bff90a4c634"
                ,"Rich Dad Poor Dad","Robert Kiyosaki",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FRich-Dad-Poor-Dad-eBook.pdf?alt=media&token=3fa75092-3eb5-45be-a07a-2783595a5ac7"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fteachyoutoberich.jfif?alt=media&token=3ddba6f6-a6f9-4391-ab42-7107322d69aa"
                ,"I Will Teach You To Be Rich","Ramit Sethi","link"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2FtheInvestmentAns.jfif?alt=media&token=a7775af4-9127-4c95-ac7b-dc3c7fd944b5"
                ,"The Investment Answer","Daniel Goldie and Gordon Murray","link"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fmillionainextdoor.jfif?alt=media&token=849ab0ed-17f9-4bf9-a41e-5dfb057365b2"
                ,"The Millionaire Next Door","Thomas J. Stanley and William D. Danko","link"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Frichhabbits.jfif?alt=media&token=2305267c-ecd0-47a5-b3da-a619e4475b02"
                ,"Rich Habits: The Daily Success Habits Of Wealthy Individuals","Thomas Corley","link"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Ffinancially%20fearless.jfif?alt=media&token=7d7b6b65-656a-45d6-8e37-eaa11e8c3654"
                ,"Financially Fearless: The LearnVest Program For Taking Control Of Your Money","Alexa Von Tobel","link"));

books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2FThknGrow.png?alt=media&token=e7e3938e-5b70-4a61-b144-4f650d732248"
                ,"Think and grow rich ","Napoleon Hill","link"));

        //self help books
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fcalender%20of%20wisdon.webp?alt=media&token=d4e63f55-01e2-4bdc-b6a2-3c9f659905c3",
                "A Calendar of Wisdom","Leo Tolstoj",
                "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fatomic%20habbits.webp?alt=media&token=3808c1fb-7feb-48c5-ae4d-e483fc376e0f",
                "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones","James Clea",
                 "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Falchemist.webp?alt=media&token=ef5b2c88-b5c4-4551-8701-2701b0833705",
                "The Alchemist"," Paulo Coelho",
                "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fwarnpeace.webp?alt=media&token=d9f01f86-cf2c-492e-a7fe-23f4b0835c16",
                "War and Peace","Leo Tolstoy",
                "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fmansearchformeaning.webp?alt=media&token=cf8e0268-ebcd-4ad5-bac6-7a8b0e2c6c10",
                "Man's Search for Meaning","Viktor Frankl",
                "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fegoisenemy.webp?alt=media&token=cd561273-717f-4209-ac12-bb0582cb42f9",
                "Ego Is the Enemy","Ryan Holiday",
                "link"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Ffooledbyrandomness.webp?alt=media&token=d62d06d6-a969-43aa-9f8b-2aa501628555",
                "Fooled by Randomness","Nassim Nicholas Taleb",
                "link"));

        // courses
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


        //linear layout manager & adapter for financial books

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        bookAdapter adapter1 = new bookAdapter(getContext(),books1list);
        books1.setAdapter(adapter1);
        books1.setHasFixedSize(false);
        books1.setLayoutManager(layoutManager1);



        //linear layout manager & adapter for self help books
  LinearLayoutManager layoutManager2
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        bookAdapter adapter2 = new bookAdapter(getContext(),books2list);
        books2.setAdapter(adapter2);
        books2.setHasFixedSize(false);
        books2.setLayoutManager(layoutManager2);

        return view;
    }
}