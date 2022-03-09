package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.freedom20.R;
import com.example.freedom20.zerodha_Fragment;

public class QnAFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qn_a, container, false);

        Button open = view.findViewById(R.id.btnclickcard);
        Button books = view.findViewById(R.id.btnBooks);
        Button Algo = view.findViewById(R.id.btnalgo);
        Button react = view.findViewById(R.id.btnreact);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creating new bundle:
                Bundle zerodha = new Bundle();
                zerodha.putString("varsity","https://zerodha.com/varsity/");
                getParentFragmentManager().setFragmentResult("dataFromQnA",zerodha);

                FragmentTransaction Fr = getFragmentManager().beginTransaction();
                Fr.replace(R.id.container,new zerodha_Fragment());
                Fr.commit();
            }
        });

        Algo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle zerodha = new Bundle();
                zerodha.putString("varsity","https://online.stanford.edu/courses/soe-ycs0009-divide-and-conquer-sorting-and-searching-and-randomized-algorithms");
                getParentFragmentManager().setFragmentResult("dataFromQnA",zerodha);

                FragmentTransaction Fr = getFragmentManager().beginTransaction();
                Fr.replace(R.id.container,new zerodha_Fragment());
                Fr.commit();
            }
        });
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle zerodha = new Bundle();
                zerodha.putString("varsity","https://scrimba.com/learn/learnreact");
                getParentFragmentManager().setFragmentResult("dataFromQnA",zerodha);

                FragmentTransaction Fr = getFragmentManager().beginTransaction();
                Fr.replace(R.id.container,new zerodha_Fragment());
                Fr.commit();
            }
        });
        return view;
    }
}