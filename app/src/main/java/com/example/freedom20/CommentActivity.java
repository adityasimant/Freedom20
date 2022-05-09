package com.example.freedom20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freedom20.Adapter.commentAdapter;
import com.example.freedom20.Models.Comment;
import com.example.freedom20.Models.Dashboard;
import com.example.freedom20.Models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

public class CommentActivity extends AppCompatActivity {
    ImageView cmtProfilePic,ImgSend;
    TextView cmtHPost,cmtMPost,cmtAuthor;
    EditText commentText;
    Intent intent;
    String postId,postedBy;
    FirebaseDatabase database;
    FirebaseAuth auth;
    ArrayList<Comment>list = new ArrayList<>();
    RecyclerView cmtRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        cmtAuthor = findViewById(R.id.commentAuthor);
        cmtHPost = findViewById(R.id.commentHpost);
        cmtMPost = findViewById(R.id.commentMpost);
        cmtProfilePic = findViewById(R.id.commentProfilepic);
        ImgSend = findViewById(R.id.commentSent);
        commentText = findViewById(R.id.ETcomment);

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

        database.getReference().child("user")
                .child(postedBy).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                Picasso.get().load(user.getProfile())
                        .placeholder(R.drawable.ic_img_placeholder)
                        .into(cmtProfilePic);
                cmtAuthor.setText("By : " + user.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ImgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Comment comment = new Comment();
                comment.setCommentBody(commentText.getText().toString());
                comment.setCommentedAt(new Date().getTime());
                comment.setCommentedBy(auth.getUid());

                database.getReference()
                        .child("post")
                        .child(postId)
                        .child("comments")
                        .push()
                        .setValue(comment)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                database.getReference()
                                        .child("post")
                                        .child(postId)
                                        .child("commentCount")
                                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                int commentCount = 0;
                                                if (snapshot.exists()){
                                                    commentCount = snapshot.getValue(Integer.class);

                                                }
                                                database.getReference()
                                                        .child("post")
                                                        .child(postId)
                                                        .child("commentCount")
                                                        .setValue(commentCount + 1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        commentText.setText("");
                                                        Toast.makeText(CommentActivity.this, "Added succesfullt", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {
                                                Toast.makeText(CommentActivity.this, "An error occured", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        });

            }
        });

        commentAdapter adapter = new commentAdapter(this,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        cmtRV = findViewById(R.id.commentRV);
        cmtRV.setLayoutManager(layoutManager);
        cmtRV.setAdapter(adapter);

        database.getReference().
                child("post")
                .child(postId)
                .child("comments").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Comment comment = dataSnapshot.getValue(Comment.class);
                    list.add(comment);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}