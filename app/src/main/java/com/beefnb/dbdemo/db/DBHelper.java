package com.beefnb.dbdemo.db;

import android.content.Context;

public class DBHelper {

    private static Context context = null;

    private volatile static DBHelper helper = null;

    private DB db = null;

    public static void init(Context mContext){
        context = mContext;
    }

    private DBHelper(){
        if (context != null){
            db = new DB(context);
        }else {
            throw new NullPointerException("context is null , please init in application");
        }
    }

    public static DBHelper getInstance(){
        if (helper == null){
            synchronized (DBHelper.class){
                if (helper == null){
                    helper = new DBHelper();
                }
            }
        }
        return helper;
    }





}
