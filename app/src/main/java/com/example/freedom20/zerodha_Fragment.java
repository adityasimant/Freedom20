package com.example.freedom20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class zerodha_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zerodha_, container, false);
        WebView webView = view.findViewById(R.id.zerodhawebview);
        webView.loadUrl("https://zerodha.com/varsity/");
        webView.setWebViewClient(new WebViewController());
        return view;
    }
}