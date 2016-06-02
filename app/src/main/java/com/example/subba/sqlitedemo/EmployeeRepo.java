package com.example.subba.sqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeRepo extends ArrayAdapter<Employee> {
    Context context;
    int layoutResourceId;
    ArrayList<Employee> data = new ArrayList<Employee>();

    public EmployeeRepo(Context context, int layoutResourceId, ArrayList<Employee> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ImageHolder();
            holder.empid = (TextView) row.findViewById(R.id.idemp);
            holder.fnam = (TextView) row.findViewById(R.id.efname);
            holder.lnam = (TextView) row.findViewById(R.id.elname);
            row.setTag(holder);
        } else {
            holder = (ImageHolder) row.getTag();
        }
        Employee picture = data.get(position);
        holder.empid.setText(String.valueOf(picture ._eid));
        holder.fnam.setText(picture ._fname);
        holder.lnam.setText(picture ._lname);
        return row;
    }

    static class ImageHolder {
        TextView fnam;
        TextView lnam;
        TextView empid;
    }
}


