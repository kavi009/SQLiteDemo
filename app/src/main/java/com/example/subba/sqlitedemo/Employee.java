package com.example.subba.sqlitedemo;

public class Employee {

    public int _id;
    public int _eid;
    public String _fname;
    public String _lname;

    public Employee() {

    }

    public Employee(int keyId, int eid, String fname, String lname) {
        this._id = keyId;
        this._eid = eid;
        this._fname = fname;
        this._lname = lname;

    }
    public Employee(int eid, String fname, String lname) {
        this._eid = eid;
        this._fname = fname;
        this._lname = lname;
    }

    public int getID() {
        return this._id;
    }


    public void setID(int keyId) {
        this._id = keyId;
    }

    public int getEID() {
        return this._eid;
    }


    public void setEID(int eid) {
        this._eid = eid;
    }


    public String getFName() {
        return this._fname;
    }


    public void setFName(String fname) {
        this._fname = fname;
    }

    public String getLName() {
        return this._lname;
    }


    public void setLName(String lname) {
        this._lname = lname;
    }


}
