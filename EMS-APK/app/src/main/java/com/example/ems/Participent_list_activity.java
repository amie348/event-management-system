package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Participent_list_activity extends AppCompatActivity {


    List<Participent> participentList = new ArrayList<>();
    ListView partiSpinner;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participent_list_activity);


        ParticipentDBHelper participentDBHelper = new ParticipentDBHelper(Participent_list_activity.this);
        participentList = participentDBHelper.getAllParticipents();

        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        ParticipentAdapter participentAdapter = new ParticipentAdapter(participentList);

        partiSpinner.setAdapter(participentAdapter);

        addbtn = findViewById(R.id.addPartbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newActivity = new Intent( Participent_list_activity.this , Participent_view_activity.class);
                startActivity(newActivity);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ParticipentDBHelper participentDBHelper = new ParticipentDBHelper(Participent_list_activity.this);
        Log.i("MY Participents" , "Resumed");
        participentList = participentDBHelper.getAllParticipents();

        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        ParticipentAdapter participentAdapter = new ParticipentAdapter(participentList);

        partiSpinner.setAdapter(participentAdapter);

    }
}