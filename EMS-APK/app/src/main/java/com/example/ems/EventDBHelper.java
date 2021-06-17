package com.example.ems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EventDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName2.db";
    public static final String EVENT_TABLE_NAME = "EVENT";
    public static final String EVENT_COLUMN_ID = "id";
    public static final String EVENT_COLUMN_TITLE = "title";
    public static final String EVENT_COLUMN_ORGANIZER = "organizer";
    public static final String EVENT_COLUMN_EVENT = "event";
    public static final String EVENT_COLUMN_DATE = "Date";
    public static final String EVENT_COLUMN_BUDGET = "budget";
    public static final String EVENT_COLUMN_LIMIT = "max_limit";
    public static final String EVENT_COLUMN_DESC = "Description";
    private HashMap hp;

    public EventDBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table EVENT " +
                        "(id integer primary key AUTOINCREMENT , title text,organizer text,event text,budget text, Date text, Description text , max_limit text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS EVENTS");
        onCreate(db);
    }

    public boolean insertEvent (String title, String organizer,String event, String budget, String Date,String Description ,String max_limit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENT_COLUMN_TITLE, title);
        contentValues.put(EVENT_COLUMN_ORGANIZER, organizer);
        contentValues.put(EVENT_COLUMN_BUDGET, budget);
        contentValues.put(EVENT_COLUMN_DATE, Date);
        contentValues.put(EVENT_COLUMN_LIMIT, max_limit);
        contentValues.put(EVENT_COLUMN_DESC, Description);
        contentValues.put(EVENT_COLUMN_EVENT, event);
        db.insert(EVENT_TABLE_NAME, null, contentValues);
        return true;
    }


    public Event getData(int Id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from EVENT where id="+Id, null );
        res.moveToFirst();
        String id = res.getString((res.getColumnIndex("id")));
        String title = res.getString(res.getColumnIndex(EVENT_COLUMN_TITLE));
        String organizer = res.getString(res.getColumnIndex(EVENT_COLUMN_ORGANIZER));
        String description = res.getString(res.getColumnIndex(EVENT_COLUMN_DESC));
        String budget = res.getString(res.getColumnIndex(EVENT_COLUMN_BUDGET));
        String event_type = res.getString(res.getColumnIndex(EVENT_COLUMN_EVENT));
        String date = res.getString(res.getColumnIndex(EVENT_COLUMN_DATE));
        String max_limit = res.getString(res.getColumnIndex(EVENT_COLUMN_LIMIT));
        // craeting Event oject to store the info. reterieved from database
        Event event = new Event(title , organizer , description , max_limit , date , budget , event_type, id);
        return event;
    }

/*
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
*/

    public Integer deleteEvent (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("EVENT",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public boolean updateEvent (Integer id, String title, String organizer,String event, String budget, String Date,String Description ,String max_limit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENT_COLUMN_TITLE, title);
        contentValues.put(EVENT_COLUMN_ORGANIZER, organizer);
        contentValues.put(EVENT_COLUMN_BUDGET, budget);
        contentValues.put(EVENT_COLUMN_DATE, Date);
        contentValues.put(EVENT_COLUMN_LIMIT, max_limit);
        contentValues.put(EVENT_COLUMN_DESC, Description);
        contentValues.put(EVENT_COLUMN_EVENT, event);
        db.update("EVENT", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public List<Event> getAllEvents() {
        //ArrayList<String> array_list = new ArrayList<String>();
        List<Event> eventList  = new ArrayList<>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from EVENT", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            String id = res.getString((res.getColumnIndex("id")));
            String title = res.getString(res.getColumnIndex(EVENT_COLUMN_TITLE));
            String organizer = res.getString(res.getColumnIndex(EVENT_COLUMN_ORGANIZER));
            String description = res.getString(res.getColumnIndex(EVENT_COLUMN_DESC));
            String budget = res.getString(res.getColumnIndex(EVENT_COLUMN_BUDGET));
            String event_type = res.getString(res.getColumnIndex(EVENT_COLUMN_EVENT));
            String date = res.getString(res.getColumnIndex(EVENT_COLUMN_DATE));
            String max_limit = res.getString(res.getColumnIndex(EVENT_COLUMN_LIMIT));
            Log.i("EVENT" , title );
            Event event = new Event(title , organizer , description, max_limit , date , budget , event_type , id );
            eventList.add(event);
            res.moveToNext();
        }
        return eventList;
    }

    public ArrayList<String> getNames(){
        ArrayList<String> Titles = new ArrayList<String>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select title from EVENT", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){


            String title = res.getString(res.getColumnIndex(EVENT_COLUMN_TITLE));
            Titles.add(title);
            res.moveToNext();
        }
        return Titles;

    }
}