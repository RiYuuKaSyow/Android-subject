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
        Button sudokustart = (Button) findViewById(R.id.sudokuStart);
        sudokustart.setOnClickListener(this);
        Button sudokurecord = (Button) findViewById(R.id.sudokuRecord);
        sudokurecord.setOnClickListener(this);
        Button TicBtn = (Button) findViewById(R.id.TictocBtn) ;
        TicBtn.setOnClickListener(this);
        Button tictoc1btn = (Button) findViewById(R.id.TictocP1Btn);
        tictoc1btn.setOnClickListener(this);
        Button tictoc2btn = (Button) findViewById(R.id.TictocP2Btn);
        tictoc2btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.sudokuStart: {
                it.setClass(this, Sudoku.class);
                startActivity(it);
                break;
            }
            case R.id.sudokuRecord: {
                it.setClass(this, SudokuRecord.class);
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
            case R.id.TictocBtn:{
                Togglebtn(R.id.TictocBtn);
                break;
            }
            case R.id.SudokuBtn:{
                Togglebtn(R.id.SudokuBtn);
                break;
            }
        }

        //it.setClass(this,Sudoku.class);

    }
    public void Togglebtn(int id){
        switch(id){
            case R.id.TictocBtn:{
                Button btn1 = (Button)findViewById(R.id.TictocP1Btn);
                Button btn2 = (Button)findViewById(R.id.TictocP2Btn);
                if(btn1.getVisibility() == View.VISIBLE){
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                }else {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                }
                break ;
            }
            case R.id.SudokuBtn:{
                Button btn1 = (Button)findViewById(R.id.sudokuStart);
                Button btn2 = (Button)findViewById(R.id.sudokuRecord);
                if(btn1.getVisibility() == View.VISIBLE){
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                }else {
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
