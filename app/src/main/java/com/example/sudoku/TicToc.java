package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TicToc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_toc);
        WebView wv = (WebView) findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl( "file:///android_asset/tictoc.html");
    }
}
