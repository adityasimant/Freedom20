package com.example.freedom20.Adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardAdapter {

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ProfilePic, morre;
        TextView username,bio,post,upvote,comment;
        Button share;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
