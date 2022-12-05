package com.example.freedom20.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.Comment;
import com.example.freedom20.Models.User;
import com.example.freedom20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class commentAdapter extends  RecyclerView.Adapter<commentAdapter.viewHolder>{

    Context context;
    ArrayList<Comment> list;

    public commentAdapter(Context context, ArrayList<Comment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Comment comment = list.get(position);
        try{
            if (comment != null){
                holder.date.setText(comment.getCommentedAt() + "");



                FirebaseDatabase.getInstance().getReference().child("user")
                        .child(comment.getCommentedBy()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        if (user != null) {
                            Picasso.get().load(user.getProfile())
                                    .placeholder(R.drawable.ic_img_placeholder)
                                    .into(holder.cmtProfilePic);
                            holder.cmtbody.setText(comment.getCommentBody());
                        holder.cmtName.setText(user.getName());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        }
        catch (Exception a){

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView cmtName,date,cmtbody;
        ImageView cmtProfilePic;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cmtName = itemView.findViewById(R.id.Cusername1);
            date = itemView.findViewById(R.id.cmtTime);
            cmtbody = itemView.findViewById(R.id.cmtbody);
            cmtProfilePic = itemView.findViewById(R.id.commentRVProfilePic);
        }
    }
}
