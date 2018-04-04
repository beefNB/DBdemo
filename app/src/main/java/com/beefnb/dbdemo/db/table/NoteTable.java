package com.beefnb.dbdemo.db.table;

public class NoteTable {

    public static final String TABLE_NAME = "NoteTable";

    public static final String ID = "id";

    public static final String CONTENT = "content";

    public static final String TIME = "time";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ( "
                                                + ID + " text primary key, "
                                                + CONTENT + " text, "
                                                + TIME + " text "
                                                + ")";

    public static final String SELECT_ALL = "select * from " + TABLE_NAME;


}
