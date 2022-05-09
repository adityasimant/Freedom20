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
                ,"I Will Teach You To Be Rich","Ramit Sethi",
         "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FI-will-teach-you-to-be-rich.pdf?alt=media&token=8f608169-3f78-4adb-8d7d-33f9b72e1f74"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2FtheInvestmentAns.jfif?alt=media&token=a7775af4-9127-4c95-ac7b-dc3c7fd944b5"
                ,"The Investment Answer","Daniel Goldie and Gordon Murray",
         "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2Fthe-investment-answer.pdf?alt=media&token=09aef3ad-a813-40ad-a153-d0a2e93e4160"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fmillionainextdoor.jfif?alt=media&token=849ab0ed-17f9-4bf9-a41e-5dfb057365b2"
                ,"The Millionaire Next Door","Thomas J. Stanley and William D. Danko",
         "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FThe%20Millionaire%20Next%20Door%20%5BBook%5D-MANTESH.PDF%20-%20Davidbeitler.com%20(%20PDFDrive%20).pdf?alt=media&token=5b62a9cc-d4b4-44a4-874a-a1c6bbfe404f"));

 books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Frichhabbits.jfif?alt=media&token=2305267c-ecd0-47a5-b3da-a619e4475b02"
                ,"Rich Habits: The Daily Success Habits Of Wealthy Individuals","Thomas Corley",
         "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2Frich-habbits.pdf?alt=media&token=3a92552c-062a-41bd-a041-6f9a5601c573"));

books1list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2FThknGrow.png?alt=media&token=e7e3938e-5b70-4a61-b144-4f650d732248"
                ,"Think and grow rich ","Napoleon Hill",
        "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FThink%20And%20Grow%20Rich%20(%20PDFDrive%20).pdf?alt=media&token=f07dac82-1415-4034-b48c-ea4e2ee9cf8d"));

        //self help books
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fcalender%20of%20wisdon.webp?alt=media&token=d4e63f55-01e2-4bdc-b6a2-3c9f659905c3",
                "A Calendar of Wisdom","Leo Tolstoj",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FA-Calendar-of-Wisdom.pdf?alt=media&token=d99de5e1-c26c-4f55-b966-7e14cd6a47d6"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fatomic%20habbits.webp?alt=media&token=3808c1fb-7feb-48c5-ae4d-e483fc376e0f",
                "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones","James Clea",
                 "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2Fatomic-habits.pdf?alt=media&token=bb151891-295c-4594-acf2-0767db76f6dd"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Falchemist.webp?alt=media&token=ef5b2c88-b5c4-4551-8701-2701b0833705",
                "The Alchemist"," Paulo Coelho",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FTHE-ALCHEMIST-pdf-free-download.pdf?alt=media&token=442dd72d-da30-429c-8ec9-6bd07bbafd22"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fwarnpeace.webp?alt=media&token=d9f01f86-cf2c-492e-a7fe-23f4b0835c16",
                "War and Peace","Leo Tolstoy",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2Fwar-and-peace.pdf?alt=media&token=fe205f95-c41c-43fb-9254-c66aca862bd3"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fmansearchformeaning.webp?alt=media&token=cf8e0268-ebcd-4ad5-bac6-7a8b0e2c6c10",
                "Man's Search for Meaning","Viktor Frankl",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FMans-Search-For-Meaning.pdf?alt=media&token=e1993458-6fc2-4399-8d47-ae4b93aae27e"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Fegoisenemy.webp?alt=media&token=cd561273-717f-4209-ac12-bb0582cb42f9",
                "Ego Is the Enemy","Ryan Holiday",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FEgo%20is%20the%20Enenmy%20(%20PDFDrive%20).pdf?alt=media&token=cf4bce87-4062-40fa-b5c8-3fb5c64a6dee"));
        books2list.add(new bookModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/bookImgs%2Ffooledbyrandomness.webp?alt=media&token=d62d06d6-a969-43aa-9f8b-2aa501628555",
                "Fooled by Randomness","Nassim Nicholas Taleb",
                "https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/BookPDF%2FFooled-by-Randomness-Role-of-Chance-in-Markets-and-Life-PROPER1.pdf?alt=media&token=363c755d-ccdd-4d43-83f2-3c67a3d2e957"));

        // courses
        booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ1.png?alt=media&token=77c96780-0d39-4b27-b8b4-d0c9de85012f",
                " Introduction to Stock Markets","Learn with Zerodha Varsity",
                "Investing ensures financial security, and the Stock market plays a pivotal role in this domain" +
                        ", it is a place where people buy/sell shares of publicly listed companies."));


 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ2.png?alt=media&token=caf6303f-e542-4d94-8e4c-a6cbd9352ddc",
                "Technical Analysis","Learn with Zerodha Varsity",
                "Technical Analysis (TA) plays an important role in developing a point of view. " +
                        "Like every other research, TA also has its own attributes"));

 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ3.png?alt=media&token=96e6ba92-ac63-4344-b801-fd5ab5b03596",
                "Fundamental Analysis","Learn with Zerodha Varsity",
                "Fundamental Analysis (FA) is a holistic approach to study a business."));

 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ4.png?alt=media&token=04583bac-6f64-4662-aa7e-d7b2b7a85007",
                " Futures Trading","Learn with Zerodha Varsity",
                "Futures Trading involves trading in contracts in the derivatives markets"));

 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ5.png?alt=media&token=0a1a7aac-c7d0-475b-8653-e825d04f7cd2",
                "Options Theory for Professional Trading","Learn with Zerodha Varsity",
                "An option is a contract where the price of the options is based on an underlying. Options contracts grant the buyer the right to buy the underlying without a compulsory obligation."));

 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ6.png?alt=media&token=d5b9d198-7df5-4efb-8d5e-d961b897e6c5",
                "Option Strategies","Learn with Zerodha Varsity",
                "The module covers various options strategies that can be built with a multi-dimensional approach based on Market trend involving Option Greeks, Risk-Return, etc."));

 booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ7.png?alt=media&token=3c163fc9-ae52-4259-93e7-fa72d3b8d1a9",
                " Markets and Taxation","Learn with Zerodha Varsity",
                "As a trader in India, you should be informed of all the taxes that are levied on your investments and account. This module overlays the taxation countenance of Investing/Trading in the Markets."));

booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ8.png?alt=media&token=5b88a9a3-2c41-46b6-8443-a3ffd05c64d7",
                "Currency, Commodity, and Government Securities","Learn with Zerodha Varsity",
                "This module covers the Currency,  MCX Commodity contract, and the Government Securities (GSec) traded in the Indian Markets."));

booksList.add(new LogsModel("https://firebasestorage.googleapis.com/v0/b/freedom20-1dc06.appspot.com/o/DocsImages%2FZ9.png?alt=media&token=e08992cb-7530-41e1-8dcf-6c4cf483aaa0",
                "Risk Management & Trading Psychology","Learn with Zerodha Varsity",
                "The module covers the risk management aspect along with the psychology required for being consistent and profitable while trading"));



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