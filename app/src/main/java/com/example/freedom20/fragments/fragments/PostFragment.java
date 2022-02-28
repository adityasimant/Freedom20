package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.freedom20.R;


public class PostFragment extends Fragment {
    Button reset,post;
    EditText etpost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        reset = view.findViewById(R.id.btnreset);
        etpost = view.findViewById(R.id.etpost);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etpost.setText(null);
            }
        });

        return view;
    }
}