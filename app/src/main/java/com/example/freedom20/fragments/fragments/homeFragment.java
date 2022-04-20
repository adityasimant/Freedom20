package com.example.freedom20.fragments.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.freedom20.Adapter.DashboardAdapter;
import com.example.freedom20.Models.Dashboard;
import com.example.freedom20.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class homeFragment extends Fragment {
    RecyclerView dashboardRV;
    ArrayList<Dashboard> DashboardList;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DashboardAdapter dashboardAdapter;
    ImageView startoffeed,endoffeed;

    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        startoffeed = view.findViewById(R.id.beginfeed);
        endoffeed = view.findViewById(R.id.endOffeed);


        dashboardRV = view.findViewById(R.id.dashboardRV);
        DashboardList = new ArrayList<>();


        dashboardAdapter = new DashboardAdapter(DashboardList,getContext());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        dashboardRV.setLayoutManager(layoutManager);
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(dashboardAdapter);



            database.getReference().child("post").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DashboardList.clear();
                    startoffeed.setVisibility(View.GONE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Dashboard dashboard = dataSnapshot.getValue(Dashboard.class);
                        dashboard.setPostId(dataSnapshot.getKey());
                        DashboardList.add(dashboard);
                    }
                    endoffeed.setVisibility(View.VISIBLE);
                    dashboardAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });



        return view;
    }
}