package com.example.alcchallenge1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class ALCWebViewClient extends WebViewClient {

    private AppCompatActivity activity;
    private ProgressBar progressBar;
    public ALCWebViewClient(AppCompatActivity activity, ProgressBar progressBar){

        this.activity = activity;
        this.progressBar = progressBar;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressBar.setVisibility(View.GONE);
        activity.setTitle(view.getTitle());
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
    }
}
