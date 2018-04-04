package com.beefnb.dbdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.beefnb.dbdemo.db.table.NoteTable;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "dbdemo";

    private static final int VERSION = 1;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NoteTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    private static Context context = null;

    public static void init(Context mContext){
        context = mContext;
    }

    private volatile static DBHelper helper = null;

    public static DBHelper getInstance(){
        if (helper == null){
            synchronized (DBHelper.class){
                if (helper == null){
                    if (context !=null){
                        helper = new DBHelper(context);
                    }else {
                        throw new NullPointerException("context is null , please init in application");
                    }
                }
            }
        }
        return helper;
    }


}
