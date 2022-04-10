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

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView Mpost,Hpost;
        ImageView ImgPost;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            Mpost =itemView.findViewById(R.id.postContent);
            Hpost =itemView.findViewById(R.id.PostHeader);
            ImgPost = itemView.findViewById(R.id.ImgPost);

        }
    }

}
