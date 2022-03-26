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

import com.example.freedom20.Models.Dashboard;
import com.example.freedom20.R;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.viewHolder> {

    ArrayList <Dashboard> list;
    Context context;

    public DashboardAdapter(ArrayList<Dashboard> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_rv_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Dashboard model = list.get(position);
        holder.ProfilePic.setImageResource(model.getProfile());
        holder.username.setText(model.getName());
        holder.post.setText(model.getPost());
        holder.bio.setText(model.getBio());
        holder.upvote.setText(model.getLike());
        holder.comment.setText(model.getComment());
        holder.share .setText(model.getShare());
        holder.text.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ProfilePic, more;
        TextView username,bio,post,upvote,comment,text;
        Button share;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.UserName);
            more = itemView.findViewById(R.id.imgVmore);
            ProfilePic = itemView.findViewById(R.id.imgVprofilepic);
            bio = itemView.findViewById(R.id.about);
            post = itemView.findViewById(R.id.post);
            upvote = itemView.findViewById(R.id.idUpvote);
            comment = itemView.findViewById(R.id.idComment);
            share = itemView.findViewById(R.id.btnShare);
            text = itemView.findViewById(R.id.TVtext);

        }
    }

}
