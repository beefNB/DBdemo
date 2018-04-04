package com.beefnb.dbdemo.db.impl;

import android.database.sqlite.SQLiteDatabase;

import com.beefnb.dbdemo.db.DBHelper;


public class BaseImpl {

    protected static SQLiteDatabase db ;

    public BaseImpl(){
        db = DBHelper.getInstance().getWritableDatabase();
    }


}
