package com.example.freedom20;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewController extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String URL) {
        view.loadUrl(URL);
        return true;
    }
}
