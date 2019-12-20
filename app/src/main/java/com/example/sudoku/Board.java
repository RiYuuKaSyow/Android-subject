package com.example.sudoku;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Board  {

    public int[][][] boards = new int[3][9][9] ;
    public Integer[] Qboard = new Integer[81];
    public Integer[] Aboard = new  Integer[81] ;
    public String[] ViewBoard = new String[81] ;
    public Board(int[][][] b){
        this.boards = b ;
        getBoard();
        randBoard();
        //TransBoard();
    }
    public void getBoard(){
        int temp = (int)(Math.random()*6) ;
        for(int i = 0 ; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                this.Qboard[i * 9 + j] = this.boards[temp][i][j];
                this.Aboard[i * 9 + j] = this.boards[temp][i][j];
            }
        }
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
            if( this.Qboard[i] != 0 ){
                this.Qboard[i] = num[this.Qboard[i] -1] ;
                this.Aboard[i] = num[this.Aboard[i] -1] ;
            }
        }
    }
    public void TransBoard(){
        Integer[] temp = this.Qboard ;
        Integer[] res = this.Qboard ;
        int times = (int)(Math.random()*6) ;
        for(int i = 0 ; i < times ; i++){
            for(int x = 0 ; x < 9 ; x++){
                for(int y = 0 ; y < 9 ; y++){
                    //res[x][y] = temp[y][8-x] ;
                    res[ (x*9)+y ] = temp[ (y*9)+8-x ] ;
                }
            }
            temp = res ;
        }
        this.Qboard = res ;
        this.Aboard = res ;
    }
    public void getView(){
        for(int i = 0 ; i < 81 ; i++) {
            if (this.Aboard[i] == 0) {
                this.ViewBoard[i] = "";
            } else {
                this.ViewBoard[i] = this.Aboard[i].toString();
            }
        }
        for(int i = 0 ; i < 81 ; i++) {
            if (this.Qboard[i] != 0) {
                this.ViewBoard[i] = this.Qboard[i].toString();
            }
        }
    }
    public boolean isFill(){
        for(int i = 0 ; i < 81 ;i++){
            if(this.ViewBoard[i] == ""){
                return false ;
            }
        }
        return true ;
    }
    public boolean Check(){
        if( checkrow() && checkcol() && checkbox() ){
            return true ;
        }
        return false ;
    }

    private boolean checkrow(){
        for(int i = 0 ; i < 9 ; i++){
            int temp = 0 ;
            for(int j = 0 ; j < 9 ; j++){
                temp += Integer.valueOf(this.ViewBoard[i*9+j]) ;
            }
            if(temp != 45){
                return false ;
            }
        }
        return true ;
    }
    private boolean checkcol(){
        for(int i = 0 ; i < 9 ; i++){
            int temp = 0 ;
            for(int j = 0 ; j < 9 ; j++){
                temp += Integer.valueOf(this.ViewBoard[j*9+i]) ;
            }
            if(temp != 45){
                return false ;
            }
        }
        return true ;
    }
    private boolean checkbox(){
        int t = 1 ;
        for(int i = 0 ; i < 21 ; i++){
            int temp = 0 ;
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    temp += Integer.valueOf(this.ViewBoard[i*3+j*9+k]) ;
                }
            }
            if(temp != 45){
                return false ;
            }
            t = (t+1) % 3 ;
            if( t == 0){
                i = i + 7 ;
            }
        }
        return true ;
    }
}
