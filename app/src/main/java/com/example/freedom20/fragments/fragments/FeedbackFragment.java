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

    EditText name,feedback,email;
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
        email = view.findViewById(R.id.etFeedbackEmail);
        submit = view.findViewById(R.id.btnFeedbackSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, email.getText());

                i.putExtra(Intent.EXTRA_SUBJECT, "feedback from F20");
                i.putExtra(Intent.EXTRA_TEXT, "Name : " + name.getText() + "\n Feedback : " + feedback.getText());

                try {
                    startActivity(Intent.createChooser(i,"Select your email "));
                }
                catch (android.content.ActivityNotFoundException exception){
                    Toast.makeText(getContext(), "email client not found ", Toast.LENGTH_SHORT).show();
                }



            }
        });


        return view;
    }
}