package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class TicToc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it= getIntent();
        int player = it.getIntExtra("player",1) ;
        switch (player){
            case 1:{
                setContentView(R.layout.activity_tic_toc);
                WebView wv = (WebView) findViewById(R.id.webview);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.loadUrl( "file:///android_asset/tictoc.html");
                break ;
            }
            case 2:{
                setContentView(R.layout.tictoc);
                final TicTocBoard tbc = new TicTocBoard();
                final GridView tbv = (GridView) findViewById(R.id.ticboard) ;
                final TextView res = (TextView) findViewById(R.id.ticres) ;
                ArrayAdapter aad = new ArrayAdapter(this,R.layout.ticslots,tbc.board);
                tbv.setAdapter(aad);
                tbv.setOnItemClickListener( new GridView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tbc.pick(position);
                        ArrayAdapter aad = new ArrayAdapter(TicToc.this,R.layout.ticslots,tbc.board);
                        tbv.setAdapter(aad);
                        switch(tbc.check()){
                            case 1:{
                                res.setText(R.string.p1w);
                               // tbv.setOnItemClickListener(null);
                                break;
                            }
                            case -1:{
                                res.setText(R.string.p2w);
                               // tbv.setOnItemClickListener(null);
                                break ;
                            }
                            case 10:{
                                res.setText(R.string.draw);
                               // tbv.setOnItemClickListener(null);
                                break ;
                            }
                        }
                    }
                } );
                break ;
            }
        }
    }
}
