package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class One_Hall_Activity extends AppCompatActivity {

    TextView hallName , capacity , rent , floor , location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_hall_layout);


        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        HallDBHelper hallDBHelper = new HallDBHelper(One_Hall_Activity.this);
        Hall hall = hallDBHelper.getData(Integer.parseInt(id));

        hallName = findViewById(R.id.Hall_Name);
        hallName.setText(hall.getHallName());

        capacity = findViewById(R.id.hall_capacity);
        capacity.setText(hall.getCapacity());

        rent = findViewById(R.id.hall_rent);
        rent.setText(hall.getRent());

        floor = findViewById(R.id.hall_floors);
        floor.setText(hall.getFloor());

        location = findViewById(R.id.hall_location);
        location.setText(hall.getLocation());

    }

}