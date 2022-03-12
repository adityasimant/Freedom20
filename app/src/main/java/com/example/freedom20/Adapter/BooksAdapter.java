package com.example.freedom20.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.BooksModel;
import com.example.freedom20.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.viewHolder> {

    ArrayList <BooksModel> list;
    Context context;

    public BooksAdapter(ArrayList<BooksModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.books_sample_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        BooksModel model = list.get(position);
        holder.image.setImageResource(model.getImg());
        holder.header.setText(model.getHeader());
        holder.webabt.setText(model.getWebsiteabt());
        holder.info.setText(model.getInfo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView header,webabt,info;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.stockImg1);
            header = itemView.findViewById(R.id.cardtitle1);
            webabt = itemView.findViewById(R.id.siteinfo1);
            info = itemView.findViewById(R.id.aboutCard1);


        }
    }
}
