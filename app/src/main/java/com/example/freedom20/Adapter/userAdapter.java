package com.example.freedom20.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.User;
import com.example.freedom20.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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
            ProfilePic = itemView.findViewById(R.id.userProfilePic);

        }
    }
}
