package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freedom20.Adapter.DashboardAdapter;
import com.example.freedom20.Models.Dashboard;
import com.example.freedom20.R;

import java.util.ArrayList;

public class homeFragment extends Fragment {
    RecyclerView dashboardRV;
    ArrayList<Dashboard> DashboardList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

//
//    public static homeFragment newInstance(String param1, String param2) {
//        homeFragment fragment = new homeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        dashboardRV = view.findViewById(R.id.dashboardRV);
        DashboardList = new ArrayList<>();
        DashboardList.add(new Dashboard(R.drawable.ic_baseline_account_circle_24,"My first post",
                "Alison Parker","Trader","30","2", "3"));

        DashboardList.add(new Dashboard(R.drawable.ic_baseline_account_circle_24,"My second post",
                "Alison Parker","Trader","30","2", "3"));

        DashboardList.add(new Dashboard(R.drawable.ic_baseline_account_circle_24,"My first post",
                "Alison Parker","Trader","30","2", "3"));

        DashboardList.add(new Dashboard(R.drawable.ic_baseline_account_circle_24,"My first post",
                "Alison Parker","Trader","30","2", "3"));

        DashboardList.add(new Dashboard(R.drawable.ic_baseline_account_circle_24,"My first post",
                "Alison Parker","Trader","30","2", "3"));

        DashboardAdapter dashboardAdapter = new DashboardAdapter(DashboardList,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dashboardRV.setLayoutManager(layoutManager);
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(dashboardAdapter);

        return view;
    }
}