package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Game extends AppCompatActivity {
    private int coordinate = 0;
    private Integer[] nums = {1,2,3,4,5,6,7,8,9} ;
    private int[][][] boards = {
            {
                    {3, 0, 9, 0, 0, 0, 0, 2, 0},
                    {0, 7, 0, 0, 0, 6, 0, 0, 5},
                    {0, 0, 0, 4, 7, 0, 0, 9, 0},
                    {4, 0, 0, 5, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 8, 7},
                    {6, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 3, 0, 6, 8, 0, 4, 0, 9},
                    {5, 0, 0, 0, 3, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 3, 0}
            },
            {
                    {0, 0, 0, 0, 0, 0, 0, 3, 0},
                    {0, 6, 2, 0, 0, 4, 0, 0, 8},
                    {5, 0, 0, 0, 0, 0, 7, 0, 0},
                    {9, 1, 0, 5, 0, 0, 0, 0, 7},
                    {0, 5, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 7, 0, 4, 2, 0, 0, 0},
                    {0, 0, 1, 0, 7, 0, 0, 0, 6},
                    {0, 0, 0, 9, 0, 6, 8, 0, 0},
                    {7, 0, 0, 0, 5, 0, 0, 0, 0}
            },
            {
                    {6, 0, 0, 0, 0, 0, 0, 3, 0},
                    {0, 0, 9, 0, 5, 8, 0, 0, 4},
                    {0, 0, 0, 0, 0, 2, 5, 0, 8},
                    {0, 0, 6, 0, 3, 0, 0, 7, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {4, 0, 0, 0, 0, 1, 2, 0, 0},
                    {0, 0, 0, 0, 6, 0, 0, 0, 5},
                    {0, 0, 8, 0, 0, 0, 0, 0, 0},
                    {0, 9, 7, 5, 2, 0, 0, 0, 0}
            }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        final Board Qborder = new Board(this.boards);
        ArrayAdapter aas = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Qborder.board);
        final GridView bd = (GridView) findViewById(R.id.board);
        bd.setAdapter(aas);
        bd.setOnItemClickListener(new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                coordinate = position ;
            }
        });
        GridView numbers = (GridView) findViewById(R.id.number);
        ArrayAdapter numaas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.nums) ;
        numbers.setAdapter(numaas);
        numbers.setOnItemClickListener(new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Qborder.board[coordinate] = nums[position] ;
                ArrayAdapter aas = new ArrayAdapter(Game.this, android.R.layout.simple_list_item_1,Qborder.board);
                bd.setAdapter(aas);
            }
        });
    }
}