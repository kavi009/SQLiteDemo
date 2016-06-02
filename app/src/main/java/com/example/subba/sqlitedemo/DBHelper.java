package com.example.subba.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 9;

    private static final String DATABASE_NAME = "empdb";

    private static final String TABLE_CONTACTS = "employee";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_EID = "eid";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EID + " INTEGER UNIQUE," + KEY_FNAME + " TEXT,"
                + KEY_LNAME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

// Create tables again
        onCreate(db);
    }

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EID,employee._eid);
        values.put(KEY_FNAME, employee._fname);
        values.put(KEY_LNAME, employee._lname);

// Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Contacts
    public List<Employee> getEmployeeList() {
        List<Employee> empList = new ArrayList<Employee>();
// Select All Query
        String selectQuery = "SELECT * FROM employee ORDER BY id";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Employee emp = new Employee();
                emp.setID(Integer.parseInt(cursor.getString(0)));
                emp.setEID(Integer.parseInt(cursor.getString(1)));
                emp.setFName(cursor.getString(2));
                emp.setLName(cursor.getString(3));
                empList.add(emp);
            } while (cursor.moveToNext());
        }
// close inserting data from database
        db.close();
// return contact list
        return empList;

    }
}