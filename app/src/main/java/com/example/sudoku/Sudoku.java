package com.example.sudoku;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Sudoku extends AppCompatActivity implements View.OnClickListener {
    private int coordinate = 0;
    private Integer[] nums = {1,2,3,4,5,6,7,8,9,0} ;
    private GameTime time = new GameTime() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it= getIntent();
        int from = it.getIntExtra("board",1) ;
        switch(from){
            case 1:break;
            case 2:{
                URL url = new URL("https://syow.000webhostapp.com/SudokuMaker.php");
                try {
                    URLConnection conn = url.openConnection();
                    StringBuffer sb = new StringBuffer();
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "/n");
                    }
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        setContentView(R.layout.activity_sudoku);
        final SudokuBoard sudokuBoard = new SudokuBoard();
        TextView res = (TextView) findViewById(R.id.sudokuRes);
        final Button postbtn = (Button) findViewById(R.id.postbtn);
        res.setText( getString(R.string.sudoku , "") );
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
        this.time.Start();
        numbers.setOnItemClickListener(new GridView.OnItemClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sudokuBoard.Aboard[coordinate] = nums[position] ;
                sudokuBoard.getView();
                ArrayAdapter aas = new ArrayAdapter(Sudoku.this, R.layout.sudokuslots, sudokuBoard.ViewBoard);
                bd.setAdapter(aas);
                TextView res = (TextView) findViewById(R.id.sudokuRes);
                if( sudokuBoard.isFill() ){
                    time.End();
                    if( sudokuBoard.Check() ){
                        res.setText(getString(R.string.sudoku ,  getString(R.string.sudoku_success,time.GetSpendTimeString())));
                        postbtn.setVisibility(View.VISIBLE);
                    }else{
                        res.setText( getString(R.string.sudoku , getString(R.string.fail) ));
                    }
                }
                res.setText("");
            }
        });

        postbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.postbtn){
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
            String key = database.child("sudoku").push().getKey() ;
            Map<String,Object> post = new HashMap<>();
            post.put("/sudoku/"+key,this.time.SpendTime);
            database.updateChildren(post);
            Button postbtn = (Button) findViewById(R.id.postbtn);
            postbtn.setVisibility(View.INVISIBLE);
        }
    }
}