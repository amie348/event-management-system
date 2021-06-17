package com.example.ems;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Hall_List_Activity extends AppCompatActivity {

    List<Hall> hallList = new ArrayList<>();
    ListView hallSpinner;
    Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_list_activity);


        HallDBHelper hallDBHelper = new HallDBHelper(Hall_List_Activity.this);
        hallList = hallDBHelper.getAllHalls();

        hallSpinner = findViewById(R.id.Halls);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        HallAdapter hallAdapter = new HallAdapter(hallList);

        hallSpinner.setAdapter(hallAdapter);

        addbtn = findViewById(R.id.addHallbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newActivity = new Intent( Hall_List_Activity.this , Hall_view_Activity.class);
                startActivity(newActivity);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        HallDBHelper hallDBHelper = new HallDBHelper(Hall_List_Activity.this);
        Log.i("MY HALL" , "Resumed");
        hallList = hallDBHelper.getAllHalls();

        hallSpinner = findViewById(R.id.Halls);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        HallAdapter hallAdapter = new HallAdapter(hallList);
        Log.i("MY HALL" , String.valueOf(hallAdapter.getCount()));

        hallSpinner.setAdapter(hallAdapter);

    }
}