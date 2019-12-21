package com.example.sudoku;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.time.Duration;
import java.time.Instant;

public class Sudoku extends AppCompatActivity {
    private int coordinate = 0;
    private Integer[] nums = {1,2,3,4,5,6,7,8,9,0} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        final SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.getView();
        ArrayAdapter aas = new ArrayAdapter(this,R.layout.sudokuslots, sudokuBoard.ViewBoard);
        final GridView bd = (GridView) findViewById(R.id.sudokuBoard);
        bd.setAdapter(aas);
        bd.setOnItemClickListener(new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                coordinate = position ;
            }
        });
        GridView numbers = (GridView) findViewById(R.id.number);
        ArrayAdapter numaas = new ArrayAdapter(this, R.layout.sudokuslots, this.nums) ;
        numbers.setAdapter(numaas);
        final Instant start = Instant.now();
        numbers.setOnItemClickListener(new GridView.OnItemClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sudokuBoard.Aboard[coordinate] = nums[position] ;
                sudokuBoard.getView();
                ArrayAdapter aas = new ArrayAdapter(Sudoku.this, R.layout.sudokuslots, sudokuBoard.ViewBoard);
                bd.setAdapter(aas);
                if( sudokuBoard.isFill() ){
                    Instant end = Instant.now();
                    TextView res = (TextView) findViewById(R.id.Res);
                    if( sudokuBoard.Check() ){
                        long time = Duration.between(start,end).toMillis() ;
                        res.setText("Success , Time:"+ String.valueOf((int)(time/60000)) + "分鐘" +  String.valueOf((int)((time%60000)/1000)) + "秒");
                    }else{
                        res.setText(R.string.fail);
                    }
                }
            }
        });

    }
}