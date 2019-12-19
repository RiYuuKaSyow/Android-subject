package com.example.sudoku;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Board  {

    public int[][][] boards ;
    public Integer[] board ;

    public Board(int[][][] b){
        this.boards = b ;
        getBoard();
    }
    public void getBoard(){
        int temp = (int)(Math.random()*3) ;
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                this.board[i*9+j] = this.boards[temp][i][j] ;
            }
        }
        randBoard();
    }
    public void randBoard(){
        int[] num = {1,2,3,4,5,6,7,8,9};
        int temp ;
        for(int i = 0 ; i < 50; i++){
            int i1 = (int)(Math.random()*9);
            int i2 = (int)(Math.random()*9);
            temp = num[i1] ; num[i1] = num[i2] ; num[i2] = temp ;
        }
        for(int i = 0 ; i < 81 ; i++){
            if( this.board[i] != 0 ){
                this.board[i] = num[this.board[i] -1] ;
            }
        }
    }

}
