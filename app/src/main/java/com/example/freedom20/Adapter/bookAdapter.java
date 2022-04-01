package com.example.freedom20.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freedom20.Models.bookModel;
import com.example.freedom20.R;
import com.example.freedom20.WebActivity;
import com.example.freedom20.fragments.fragments.QnAFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class bookAdapter extends RecyclerView.Adapter<BookViewHolder>{

    private Context context1;
    private List<bookModel> list;

    public bookAdapter(Context context, List<bookModel> list) {
        this.context1 = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context1);
        View view = inflater.inflate(R.layout.books,null);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder,  int position) {

        bookModel model = list.get(position);

        holder.titlebook.setText(model.getTitle());
        holder.auth.setText(model.getAuthor());
        Picasso.get().load(model.getBook()).placeholder(R.drawable.ic_img_placeholder).into(holder.bookimg);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView bookcard;
    TextView titlebook;
    TextView auth;
    ImageView bookimg;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);

        bookcard = itemView.findViewById(R.id.bookcard);
        titlebook = itemView.findViewById(R.id.idbooktitle);
        auth = itemView.findViewById(R.id.author);
        bookimg = itemView.findViewById(R.id.bookimg);
        bookcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), WebActivity.class);
//        intent.putExtra("url","https://google.com");
        intent.putExtra("url","http://www.lequydonhanoi.edu.vn/upload_images/S%C3%A1ch%20ngo%E1%BA%A1i%20ng%E1%BB%AF/Rich%20Dad%20Poor%20Dad.pdf");
        v.getContext().startActivity(intent);

    }
}
