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
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction Fr = getFragmentManager().beginTransaction();
                Fr.replace(R.id.container,new zerodha_Fragment());
                Fr.commit();
            }
        });


        return view;
    }
}