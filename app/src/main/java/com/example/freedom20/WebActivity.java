package com.example.freedom20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.freedom20.fragments.fragments.QnAFragment;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");


        webView = findViewById(R.id.webview1);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewController());


    }
}