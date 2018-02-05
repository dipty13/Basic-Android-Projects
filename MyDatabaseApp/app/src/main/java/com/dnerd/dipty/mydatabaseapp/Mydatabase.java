package com.dnerd.dipty.mydatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dipty on 10/30/2017.
 */

public class Mydatabase {

    public static final String DB_NAME = "empDB";
    Myhelper myhelper;
    Context myContext;
    SQLiteDatabase sdb;


    //creating a constructor
    public Mydatabase(Context context) {
        this.myContext = context;

        myhelper = new Myhelper(myContext, DB_NAME, null, 1);


    }

    public void open()
    {
        sdb = myhelper.getWritableDatabase();
    }
    public void empInsert(ContentValues cv)
    {
        sdb.insert("employee",null,cv);
    }

    public Cursor getEmp()
    {
        sdb = myhelper.getReadableDatabase();
        Cursor c = sdb.query("employee",null,null,null,null,null,null);
        return c;
    }


}
