package com.example.sudoku;

import java.time.Duration;
import java.time.Instant;

public class GameTime {
    public Instant StartTime ;
    public Instant EndTime ;
    public long SpendTime ;
    public String SpendTimeString ;

    public void Start(){
        this.StartTime = Instant.now();
    }
    public void End(){
        this.EndTime = Instant.now() ;
    }
    public long GetSpendTime(){
        this.SpendTime = Duration.between(this.StartTime,this.EndTime).toMillis() ;
        return this.SpendTime ;
    }
    public String GetSpendTimeString(){
        this.SpendTime = Duration.between(this.StartTime,this.EndTime).toMillis() ;
        this.SpendTimeString = String.valueOf((int)SpendTime/60000) + "分" + String.valueOf((int)(SpendTime%60000/1000)) + "秒";
        return this.SpendTimeString ;
    }
    public void longtoString(){
        this.SpendTimeString = String.valueOf((int)SpendTime/60000) + "分" + String.valueOf((int)(SpendTime%60000/1000)) + "秒";
    }
}
