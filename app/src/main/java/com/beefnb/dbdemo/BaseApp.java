package com.beefnb.dbdemo;

import android.app.Application;
import android.util.Log;

import com.beefnb.dbdemo.db.DBHelper;

public class BaseApp extends Application{

    private static final String TAG = BaseApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        DBHelper.init(this);
    }
    
}
