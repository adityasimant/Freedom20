package com.example.freedom20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freedom20.Models.Dashboard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CommentActivity extends AppCompatActivity {
    ImageView cmtProfilePic;
    TextView cmtHPost,cmtMPost,cmtAuthor;
    Intent intent;
    String postId,postedBy;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        cmtAuthor.findViewById(R.id.commentAuthor);
        cmtHPost.findViewById(R.id.commentHpost);
        cmtMPost.findViewById(R.id.commentMpost);
        cmtProfilePic.findViewById(R.id.commentProfilepic);

        intent = getIntent();
        postId = intent.getStringExtra("postId");
        postedBy = intent.getStringExtra("postedBy");

        database.getReference().child("post")
                .child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Dashboard dashboard = snapshot.getValue(Dashboard.class);
                cmtHPost.setText(dashboard.getHpost());
                cmtMPost.setText(dashboard.getMpost());
//                cmtAuthor.setText("By ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        database.getReference().child()
    }
}