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

public class Event_List_Activity extends AppCompatActivity {

    List<Event> eventList = new ArrayList<>();
    ListView Eventspinner;
    Button addbtn , refbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list_acaticty);

//        get_data();

        EventDBHelper eventDbHelper = new EventDBHelper(Event_List_Activity.this);
        eventList = eventDbHelper.getAllEvents();
        Eventspinner = findViewById(R.id.scholerships);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        EventAdapter listadapter = new EventAdapter(eventList);
        Eventspinner.setAdapter(listadapter);

        addbtn = findViewById(R.id.addnewbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent( Event_List_Activity.this, Event_view_Activity.class);
                startActivity(newActivity);
            }
        });

        refbtn = findViewById(R.id.refbtn);
        refbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        EventDBHelper eventDbHelper = new EventDBHelper(Event_List_Activity.this);
        Log.i("EVENTS" , "Resumed");
        eventList = eventDbHelper.getAllEvents();

        Eventspinner = findViewById(R.id.scholerships);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        EventAdapter listadapter = new EventAdapter(eventList);
        Eventspinner.setAdapter(listadapter);

    }

    /*
    public  void get_data()
    {
        String json;
        InputStream is = null;
        try {
            is = getAssets().open("Event.json");

            File extdir1 = Environment.getExternalStorageDirectory();
            File myDatadir1 = new File(extdir1 , "/testing");
            if(!myDatadir1.exists()){
                Toast.makeText(this , "File dose not exist",Toast.LENGTH_LONG).show();
            }

            File myfile1 = new File(myDatadir1 , "Event.json");

            FileInputStream fis = new FileInputStream(myfile1);

            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            json = new String(buffer , "UTF-8");


            JSONArray jsonarray = new JSONArray(json);


            for (int i=0 ; i<jsonarray.length();i++)
            {
                JSONObject obj = jsonarray.getJSONObject(i);

                Event s = new Event(obj.getString("Title"),obj.getString("From"),obj.getString("Description") ,obj.getString("Province"), obj.getString("Date") , obj.getString("Degree"));

                eventList.add(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/


}