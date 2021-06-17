package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Event_One_Record extends AppCompatActivity {

    TextView title , org , date , desc , limit , budget , event_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_one__record);

        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        EventDBHelper eventDbHelper = new EventDBHelper(Event_One_Record.this);
        Event event = eventDbHelper.getData(Integer.parseInt(id));

        title = findViewById(R.id.view_title);
        title.setText(event.getTitle());

        org = findViewById(R.id.view_org);
        org.setText(event.getOrganizer());

        date = findViewById(R.id.view_date);
        date.setText(event.getDate());

        desc = findViewById(R.id.view_desc);
        desc.setText(event.getDescription());

        limit = findViewById(R.id.view_limit);
        limit.setText(event.getLimit());

        budget = findViewById(R.id.view_budget);
        budget.setText(event.getBudget());

        event_type = findViewById(R.id.view_event);
        event_type.setText(event.getEvent());


    }
}