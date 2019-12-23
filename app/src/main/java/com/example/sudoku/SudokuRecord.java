package com.example.sudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SudokuRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_record);
        final ArrayList<String> datas = new ArrayList<String>();

        Query query = FirebaseDatabase.getInstance().getReference().child("sudoku").orderByValue().limitToFirst(50) ;
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if( dataSnapshot.exists() ){
                    for(DataSnapshot data : dataSnapshot.getChildren()){
                        GameTime time = new GameTime();
                        time.SpendTime = Long.parseLong( data.getValue().toString() ) ;
                        time.longtoString();
                        datas.add(time.SpendTimeString);
                    }
                }
                ListView list = (ListView) findViewById(R.id.recordList);
                final ArrayAdapter<String> aad = new ArrayAdapter<String>(SudokuRecord.this,android.R.layout.simple_list_item_1,datas);
                list.setAdapter(aad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
