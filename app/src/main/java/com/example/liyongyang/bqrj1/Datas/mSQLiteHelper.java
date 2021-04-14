package com.example.liyongyang.bqrj1.Datas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mSQLiteHelper extends SQLiteOpenHelper {
    public mSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public mSQLiteHelper( Context context, String name, int version){
        this(context ,name, null, version);
    }

    public mSQLiteHelper( Context context, String name){
        this(context ,name, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table bqdata(id integer PRIMARY KEY ,neirong text,time text)");
        //表名bqdata，有id，内容，时间三部分
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
