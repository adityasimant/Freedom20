package com.example.freedom20.fragments.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.freedom20.R;

public class FeedbackFragment extends Fragment {

    EditText name,feedback;
    Button submit;
    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        name = view.findViewById(R.id.etFeedbackName);
        feedback = view.findViewById(R.id.etFeedback);
//        email = view.findViewById(R.id.etFeedbackEmail);
        submit = view.findViewById(R.id.btnFeedbackSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "adityasimant88@gmail.com" });
                i.putExtra(Intent.EXTRA_SUBJECT, "feedback from F20");
                i.putExtra(Intent.EXTRA_TEXT, "Name : " + name.getText().toString() + "\n Feedback : " + feedback.getText().toString());

                startActivity(Intent.createChooser(i,"Select your email "));




            }

        });


        return view;
    }
}