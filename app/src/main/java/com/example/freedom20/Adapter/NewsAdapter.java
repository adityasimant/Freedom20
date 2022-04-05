package com.example.freedom20.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freedom20.Models.NewsModel;
import com.example.freedom20.R;
import com.example.freedom20.WebActivity;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<NewsModel> list;


    public NewsAdapter(Context context, ArrayList<NewsModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_sample,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.time.setText(list.get(position).getPublishedAt());
        holder.author.setText(list.get(position).getAuthor());
        holder.heading.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getDescription());
        Glide.with(context).load(list.get(position).getUrlToImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content1);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.Newstime);
            imageView = itemView.findViewById(R.id.newsImgView);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
