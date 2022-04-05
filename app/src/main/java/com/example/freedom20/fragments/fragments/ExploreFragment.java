package com.example.freedom20.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freedom20.Adapter.NewsAdapter;
import com.example.freedom20.ApiUtilities;
import com.example.freedom20.Models.MainNews;
import com.example.freedom20.Models.NewsModel;
import com.example.freedom20.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExploreFragment extends Fragment {

    String API_KEY = "6145e685abf94175bbaaf2161c6ba8ad";
    ArrayList<NewsModel> modelArrayList;
    String country = "in";
    private RecyclerView recyclerViewFinance;
    NewsAdapter adapter;
    private String category = "business";

    public ExploreFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerViewFinance = view.findViewById(R.id.RVfinanceNews);
        modelArrayList = new ArrayList<>();
        recyclerViewFinance.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsAdapter(getContext(),modelArrayList);
        recyclerViewFinance.setAdapter(adapter);
        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getFinanceNews(country,category,100,API_KEY).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                modelArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}