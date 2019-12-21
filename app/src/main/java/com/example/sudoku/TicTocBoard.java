package com.example.sudoku;

import java.util.ArrayList;

public class TicTocBoard {
    public ArrayList<String> board = new ArrayList<String>()  ;
    public int player = 0 ;

    public TicTocBoard(){
        for(int i = 0 ; i < 9 ; i++){
            this.board.add("");
        }
    }
    public void pick(int index){
        switch (this.player){
            case 0:{
                this.board.set(index,"O");
                break ;
            }
            case 1:{
                this.board.set(index,"X");
                break;
            }
        }
        this.player = (this.player+1)%2 ;
    }
    public int check(){
        int res = checkrow() + checkcol() + checkline() ;
        if( res == 0 &&isFill() ){
            return 10 ;
        }
        return res ;
    }

    public int checkrow(){
        for(int i = 0 ; i < 3 ; i++){
            int count = 0 ;
            for(int j = 0 ; j < 3 ; j++){
                switch(this.board.get(i*3+j)){
                    case "":{
                        count += 0 ;
                        break ;
                    }
                    case "O":{
                        count += 2 ;
                        break ;
                    }
                    case "X":{
                        count -= 1 ;
                        break ;
                    }
                }
            }
            if(count == 6){
                return 1 ;
            }else if(count == -3){
                return -1 ;
            }
        }
        return 0 ;
    }
    public int checkcol(){
        for(int i = 0 ; i < 3 ; i++){
            int count = 0 ;
            for(int j = 0 ; j < 3 ; j++){
                switch(this.board.get(i+j*3)){
                    case "":{
                        count += 0 ;
                        break ;
                    }
                    case "O":{
                        count += 2 ;
                        break ;
                    }
                    case "X":{
                        count -= 1 ;
                        break ;
                    }
                }
            }
            if(count == 6){
                return 1 ;
            }else if(count == -3){
                return -1 ;
            }
        }
        return 0 ;
    }
    public int checkline(){
        int count = 0 ;
        for(int i = 0 ; i <9 ; i+=4){
            switch(this.board.get(i)){
                case "":{
                    count += 0 ;
                    break ;
                }
                case "O":{
                    count += 2 ;
                    break ;
                }
                case "X":{
                    count -= 1 ;
                    break ;
                }
            }
        }
        if(count == 6){
            return 1 ;
        }else if(count == -3){
            return -1 ;
        }
        count = 0 ;
        for(int i = 2 ; i <7 ; i+=2){
            switch(this.board.get(i)){
                case "":{
                    count += 0 ;
                    break ;
                }
                case "O":{
                    count += 2 ;
                    break ;
                }
                case "X":{
                    count -= 1 ;
                    break ;
                }
            }
        }
        if(count == 6){
            return 1 ;
        }else if(count == -3){
            return -1 ;
        }
        return 0 ;
    }

    public boolean isFill(){
        if( this.board.indexOf("") < 0 ) return true ;
        return false ;
    }

}
