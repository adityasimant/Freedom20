package com.example.freedom20.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.User;
import com.example.freedom20.Models.followModel;
import com.example.freedom20.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

public class userAdapter extends RecyclerView.Adapter<userAdapter.viewHolder>{

    Context context;
    ArrayList <User> list;

    public userAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_follow,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        User user = list.get(position);

        Picasso.get().load(user.getProfile()).placeholder(R.drawable.ic_img_placeholder).into(holder.ProfilePic);
        holder.username.setText(user.getName());
        holder.bio.setText(user.getUsername());

        FirebaseDatabase.getInstance().getReference()
                .child("user").child(user.getUserID()).child("followers")
                .child(FirebaseAuth.getInstance().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    holder.follow.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.btn_following));
                    holder.follow.setText("Following");
                    holder.follow.setTextColor(context.getResources().getColor(R.color.white));

                    holder.follow.setEnabled(false);
                }
                else{
                    holder.follow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            followModel follow = new followModel();
                            follow.setFollowedBy(FirebaseAuth.getInstance().getUid());
                            follow.setFollowedAt(new Date().getTime());

                            FirebaseDatabase.getInstance().getReference()
                                    .child("user")
                                    .child(user.getUserID())
                                    .child("followers")
                                    .child(FirebaseAuth.getInstance().getUid())
                                    .setValue(follow).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    FirebaseDatabase.getInstance().getReference()
                                            .child("user")
                                            .child(user.getUserID())
                                            .child("FollowerCount")
                                            .setValue(user.getFollowerCount() + 1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {

                                            Toast.makeText(context, "Followed" + user.getName(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            });

                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView username,bio;
        ImageView ProfilePic;
        Button follow;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username1);
            follow = itemView.findViewById(R.id.btnfollow);
            bio = itemView.findViewById(R.id.bio1);
            ProfilePic = itemView.findViewById(R.id.DiscoveruserProfilePic);

        }
    }
}
