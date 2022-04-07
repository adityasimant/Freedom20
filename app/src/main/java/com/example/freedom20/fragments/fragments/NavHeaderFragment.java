package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freedom20.Models.NavModel;
import com.example.freedom20.Models.User;
import com.example.freedom20.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class NavHeaderFragment extends Fragment {

  TextView name,email;
  FirebaseAuth auth;
  FirebaseDatabase database;
  ImageView profilepic;
    public NavHeaderFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_header, container, false);

        name = view.findViewById(R.id.NavName);
        email = view.findViewById(R.id.NavEmail);
        profilepic = view.findViewById(R.id.NavProfilepic);

        NavModel model = new NavModel();
        name.setText("slim shady eminem");
//        email.setText(model.getEmail());
        Picasso.get().load(model.getProfileUrl())
                .placeholder(R.drawable.ic_img_placeholder)
                .into(profilepic);


        return view;

    }
}