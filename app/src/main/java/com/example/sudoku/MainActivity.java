package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Button sudokubtn = (Button) findViewById(R.id.SudokuBtn);
        sudokubtn.setOnClickListener(this);
        Button tictocbtn = (Button) findViewById(R.id.TictocBtn);
        tictocbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.SudokuBtn: {
                it.setClass(this, Sudoku.class);
                startActivity(it);
                break;
            }
            case R.id.TictocBtn: {
                it.setClass(this,TicToc.class);
                startActivity(it);
                break;
            }
        }

        //it.setClass(this,Sudoku.class);

    }
}
