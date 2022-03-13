package com.example.freedom20.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentResultOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.BooksModel;
import com.example.freedom20.R;
import com.example.freedom20.WebActivity;

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

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView header,webabt,info;
        Button btnclk;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            image = itemView.findViewById(R.id.stockImg1);
            header = itemView.findViewById(R.id.cardtitle1);
            webabt = itemView.findViewById(R.id.siteinfo1);
            info = itemView.findViewById(R.id.aboutCard1);
            btnclk = itemView.findViewById(R.id.btnclickcard);

            btnclk.setOnClickListener(this);
        }
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, WebActivity.class);
            switch (position){

                case 0 :
                    intent.putExtra("url","https://zerodha.com/varsity/");
                    context.startActivity(intent);
                    break;
                    case 1:
                    intent.putExtra("url","https://online.stanford.edu/courses/soe-ycs0009-divide-and-conquer-sorting-and-searching-and-randomized-algorithms");
                    context.startActivity(intent);
                    break;
                    case 2 :
                    intent.putExtra("url","https://scrimba.com/learn/learnreact");
                    context.startActivity(intent);
                    break;
                default:
                    break;


            }
        }


    }




}
