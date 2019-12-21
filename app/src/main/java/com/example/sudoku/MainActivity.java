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
        Button tictoc1btn = (Button) findViewById(R.id.TictocP1Btn);
        tictoc1btn.setOnClickListener(this);
        Button tictoc2btn = (Button) findViewById(R.id.TictocP2Btn);
        tictoc2btn.setOnClickListener(this);
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
            case R.id.TictocP1Btn: {
                it.setClass(this,TicToc.class);
                it.putExtra("player",1);
                startActivity(it);
                break;
            }
            case R.id.TictocP2Btn: {
                it.setClass(this,TicToc.class);
                it.putExtra("player",2);
                startActivity(it);
                break;
            }
        }

        //it.setClass(this,Sudoku.class);

    }
}
