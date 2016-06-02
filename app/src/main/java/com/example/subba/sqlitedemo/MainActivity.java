package com.example.subba.sqlitedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> imageArry = new ArrayList<Employee>();
    EmployeeRepo adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(this);

        Log.d("Insert: ", "Inserting ..");
        db.addEmployee(new Employee(1,"X","X"));
        db.addEmployee(new Employee(2,"Y","Y"));
        db.addEmployee(new Employee(3,"Z","Z"));
        db.addEmployee(new Employee(4,"W","W"));


// Reading all employees from database
        List<Employee> contacts = db.getEmployeeList();
        for (Employee cn : contacts) {
            String log = "ID:" + cn.getID() + " Id" + cn.getEID() +
                    " First Name: " + cn.getFName() +" ,Last Name: " + cn.getLName();

            Log.d("Result: ", log);
            imageArry.add(cn);

        }
        adapter = new EmployeeRepo(this, R.layout.emp_entry,
                imageArry);
        ListView dataList = (ListView) findViewById(R.id.list);
        dataList.setAdapter(adapter);
    }
}

