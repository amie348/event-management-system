package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Participent_One_Record extends AppCompatActivity {
    TextView name , sureName , age , cnic , event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participent_one_record);


        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        ParticipentDBHelper participentDBHelper = new ParticipentDBHelper(Participent_One_Record.this);
        Participent participent = participentDBHelper.getData(Integer.parseInt(id));

        name = findViewById(R.id.First_Name);
        name.setText(participent.getName());

        sureName = findViewById(R.id.Sure_Name);
        sureName.setText(participent.getSureName());

        age = findViewById(R.id.AgE);
        age.setText(participent.getAge());

        cnic = findViewById(R.id.CniC);
        cnic.setText(participent.getCNIC());

        event = findViewById(R.id.EveNt);
        event.setText(participent.getEvent());




    }
}