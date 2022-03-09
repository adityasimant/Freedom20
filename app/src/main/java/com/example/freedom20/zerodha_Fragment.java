package com.example.freedom20;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class zerodha_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Bundle bundle = this.getArguments();
//        String link = bundle.getString("varsity");
        View view = inflater.inflate(R.layout.fragment_zerodha_, container, false);
        WebView webView = view.findViewById(R.id.webView);
        getParentFragmentManager().setFragmentResultListener("dataFromQnA", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String link = result.getString("varsity");

                webView.loadUrl(link);
                webView.setWebViewClient(new WebViewController());
            }
        });


        return view;
    }
}