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
import com.example.freedom20.Models.User;
import com.example.freedom20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

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
        try{
            holder.ImgPost.setVisibility(View.VISIBLE);
            Picasso.get().load(model.getPostImg())
                    .into(holder.ImgPost);

            holder.Hpost.setText(model.getHpost());
            holder.Mpost.setText(model.getMpost());

        }
        catch (Exception exception){
            holder.ImgPost.setVisibility(View.GONE);
            holder.Hpost.setText(model.getHpost());
            holder.Mpost.setText(model.getMpost());
        }


        FirebaseDatabase.getInstance().getReference().child("user")
                .child(model.getPostedBy()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                Picasso.get().load(user.getProfile())
                        .placeholder(R.drawable.ic_img_placeholder)
                        .into(holder.ProfileImage);
                holder.name.setText(user.getName());
                holder.bio.setText(user.getUsername());
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
        TextView Mpost,Hpost,name ,bio;
        ImageView ImgPost,ProfileImage;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            Mpost =itemView.findViewById(R.id.postContent);
            Hpost =itemView.findViewById(R.id.PostHeader);
            ImgPost = itemView.findViewById(R.id.ImgPost);
            ProfileImage = itemView.findViewById(R.id.imgVprofilepic);
            name = itemView.findViewById(R.id.UserName);
            bio = itemView.findViewById(R.id.about);


        }
    }

}
