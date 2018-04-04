package com.beefnb.dbdemo.db.dao;


import android.content.ContentValues;

import java.util.List;


public  interface BaseDao<T> {

    void insert(T t);

    void delete(T t);

    void update(T t);

    List<T> query();

    ContentValues buildContentValues(T t);
}
