package com.example.freedom20.fragments.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freedom20.Models.Dashboard;
import com.example.freedom20.Models.User;
import com.example.freedom20.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Date;


public class PostFragment extends Fragment {
    Button reset,post;
    EditText etMpost,etHpost;
    TextView name,Pbio;
    ImageView gallerySelect,postImg,Pimg;
    Uri uri;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    ProgressDialog dialog;


    public PostFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        dialog = new ProgressDialog(getContext());


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        reset = view.findViewById(R.id.btnreset);

        etMpost = view.findViewById(R.id.etpost);
        etHpost = view.findViewById(R.id.etHeader);
        post = view.findViewById(R.id.btnPost);
        gallerySelect = view.findViewById(R.id.gallerySelect);
        postImg = view.findViewById(R.id.ImgViewPost);



        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Uploading");
        dialog.setMessage("Please wait a moment ");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);






        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMpost.setText(null);
                etHpost.setText(null);
            }
        });

        etMpost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String descp = etMpost.getText().toString();
                if (!descp.isEmpty()){
                    post.setEnabled(true);
                }
                else {
                    post.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        gallerySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,69);
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                final StorageReference reference = storage.getReference().child("post").child(auth.getUid()).child(new Date().getTime() + "");
               try {
                   reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                       @Override
                       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                           reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                               @Override
                               public void onSuccess(Uri uri) {
                                   Dashboard dashboard = new Dashboard();

                                   String temp = uri.toString();

                                   if (temp != "") {
                                       dashboard.setPostImg(uri.toString());
                                   }

                                   dashboard.setPostedBy(auth.getUid());
                                   if (etHpost.getText().toString() != "") {
                                       dashboard.setHpost(etHpost.getText().toString());
                                   }

                                   if (etMpost.getText().toString() != "") {
                                       dashboard.setMpost(etMpost.getText().toString());
                                   }
                                   dashboard.setPostedAt(new Date().getTime());


                                   database.getReference().child("post").push().setValue(dashboard).addOnSuccessListener(new OnSuccessListener<Void>() {
                                       @Override
                                       public void onSuccess(Void unused) {
                                           dialog.dismiss();
                                           Toast.makeText(getContext(), "Dashboard succesful", Toast.LENGTH_SHORT).show();
                                       }
                                   });
                               }
                           });
                       }
                   });
               }
               catch (Exception ex){
                   Dashboard dashboard = new Dashboard();
                   dashboard.setHpost(etHpost.getText().toString());
                   dashboard.setMpost(etMpost.getText().toString());
                   dashboard.setPostedAt(new Date().getTime());
                   dashboard.setPostedBy(FirebaseAuth.getInstance().getUid());
                   database.getReference().child("post").push().setValue(dashboard).addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void unused) {
                           dialog.dismiss();
                           Toast.makeText(getContext(), "Dashboard succesful", Toast.LENGTH_SHORT).show();
                       }
                   });

               }
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data.getData()!=null){
            uri = data.getData();
            postImg.setImageURI(uri);
            postImg.setVisibility(View.VISIBLE);
            post.setEnabled(true);
        }


    }
}