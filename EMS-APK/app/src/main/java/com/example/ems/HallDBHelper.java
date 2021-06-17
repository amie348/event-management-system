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

public class HallDBHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String HALL_TABLE_NAME = "HALL";
    public static final String HALL_COLUMN_ID = "id";
    public static final String HALL_COLUMN_HALLNAME = "hallName";
    public static final String HALL_COLUMN_RENT = "rent";
    public static final String HALL_COLUMN_CAPACITY = "capacity";
    public static final String HALL_COLUMN_FLOORS = "floors";
    public static final String HALL_COLUMN_LOCATION = "location";
    private HashMap hp;

    public HallDBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table HALL " +
                        "(id integer primary key AUTOINCREMENT , hallName text,rent text,capacity text,floors text, location text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS HALL");
        onCreate(db);
    }

    public boolean insertHall (String hallName, String capacity,String floors, String rent, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HALL_COLUMN_CAPACITY , capacity);
        contentValues.put(HALL_COLUMN_FLOORS , floors);
        contentValues.put(HALL_COLUMN_RENT , rent);
        contentValues.put(HALL_COLUMN_HALLNAME , hallName);
        contentValues.put(HALL_COLUMN_LOCATION , location);
        db.insert(HALL_TABLE_NAME, null, contentValues);
        return true;
    }


    public Hall getData(int Id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from HALL where id="+Id, null );
        res.moveToFirst();
        String id = res.getString((res.getColumnIndex("id")));
        String hallName = res.getString(res.getColumnIndex(HALL_COLUMN_HALLNAME));
        String capacity = res.getString(res.getColumnIndex(HALL_COLUMN_CAPACITY));
        String floors = res.getString(res.getColumnIndex(HALL_COLUMN_FLOORS));
        String rent = res.getString(res.getColumnIndex(HALL_COLUMN_RENT));
        String location = res.getString(res.getColumnIndex(HALL_COLUMN_LOCATION));

        // craeting Event oject to store the info. reterieved from database
        Hall hall = new Hall(hallName , location,capacity , floors , rent , id);
        return hall;
    }

/*
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }
*/

    public Integer deleteHall (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("HALL",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public boolean updateHall (Integer id,String hallName, String capacity,String floors, String rent, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HALL_COLUMN_LOCATION , location);
        contentValues.put(HALL_COLUMN_HALLNAME , hallName);
        contentValues.put(HALL_COLUMN_RENT , rent);
        contentValues.put(HALL_COLUMN_FLOORS , floors);
        contentValues.put(HALL_COLUMN_CAPACITY , capacity);
        db.update("HALL", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public List<Hall> getAllHalls() {
        //ArrayList<String> array_list = new ArrayList<String>();
        List<Hall> hallList  = new ArrayList<>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from HALL", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            String id = res.getString((res.getColumnIndex("id")));
            String hallName = res.getString(res.getColumnIndex(HALL_COLUMN_HALLNAME));
            String capacity = res.getString(res.getColumnIndex(HALL_COLUMN_CAPACITY));
            String floors = res.getString(res.getColumnIndex(HALL_COLUMN_FLOORS));
            String rent = res.getString(res.getColumnIndex(HALL_COLUMN_RENT));
            String location = res.getString(res.getColumnIndex(HALL_COLUMN_LOCATION));
            Log.i("HALL" , hallName );
            Hall hall = new Hall(hallName , location , capacity, floors , rent , id );
            hallList.add(hall);
            //eventList.add(event);
            res.moveToNext();
        }
        return hallList;
    }

    public ArrayList<String> getNames(){
        ArrayList<String> hallNames = new ArrayList<String>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select hallName from HALL", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){


            String hallName = res.getString(res.getColumnIndex(HALL_COLUMN_HALLNAME));
            hallNames.add(hallName);
            res.moveToNext();
        }

        return hallNames;

    }
}
