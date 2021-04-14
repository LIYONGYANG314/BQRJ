package com.example.liyongyang.bqrj1.Datas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SQL_options {
    Context mContext;
    mSQLiteHelper mSqliteHelper;
    SQLiteDatabase mDatabase;

    public SQL_options(Context context){
        this.mContext = context;
        mSqliteHelper = new mSQLiteHelper(mContext,"Datas");//数据库名叫Datas
    }

    /**
     * 实现增删查改四个功能，还有打开程序时的数据库导入。
     */


    /**
     *增加操作
     */
    public void zeng(Bq_Data Data){
        mDatabase = mSqliteHelper.getWritableDatabase();//写入方式
        mDatabase.execSQL("insert into bqdata(id,neirong,time)values('"+Data.getId()+"','"+Data.getNeirong()+"','"+Data.getTime()+"')");
        mDatabase.close();

    }

    /**
     * 删除操作
     * @param id
     */
    public void shan(int id){

        mDatabase = mSqliteHelper.getWritableDatabase();

        mDatabase.execSQL("delete from bqdata where id= " +id);//根据ID来删，也就是在按下删除按钮十传ID进来

        mDatabase.close();

    }

    /**
     * 查找操作
     * @param id
     * @return
     */
    public Bq_Data cha(int id) {
        mDatabase = mSqliteHelper.getWritableDatabase();

        Cursor cs = mDatabase.query("bqdata", new String[]{"neirong", "time"}, "id = ?", new String[]{"" + id}, null, null, null);
        cs.moveToFirst();

        String neirong = cs.getString(cs.getColumnIndex("neirong"));
        String time = cs.getString(cs.getColumnIndex("time"));

        Bq_Data Data = new Bq_Data(id,neirong,time);
        mDatabase.close();
        return Data;
    }

    /**
     * 修改操作
     * @param Data
     */
    public void gai(Bq_Data Data){
        mDatabase = mSqliteHelper.getWritableDatabase();

        mDatabase.execSQL("update bqdata set neirong = '"+Data.getNeirong()+"',time = '"+Data.getTime()+"'where id = '"+Data.getId()+"'");

        mDatabase.close();

    }

    /**
     * 对数据库中数据的读取
     * @return
     */
    public ArrayList<Bq_Data> mList(){

        ArrayList<Bq_Data> mlist = new ArrayList<Bq_Data>();

        mDatabase = mSqliteHelper.getWritableDatabase();
        Cursor cs =mDatabase.rawQuery("select id,neirong,time from bqdata",null);
        cs.moveToFirst();

        while(!cs.isAfterLast()){
            int id = cs.getInt(cs.getColumnIndex("id"));
            String neirong = cs.getString(cs.getColumnIndex("neirong"));
            String time = cs.getString(cs.getColumnIndex("time"));

            Bq_Data Data = new Bq_Data(id, neirong, time);
            mlist.add(Data);
            cs.moveToNext();
        }
        mDatabase.close();
        return mlist;
    }

    /**
     * 删除整个数据库数据
     */
    public void Del_Table(){
        mDatabase = mSqliteHelper.getWritableDatabase();
        mDatabase.execSQL("DELETE FROM " + "bqdata");
        mDatabase.close();
    }

    /**
     * 删除后更新id
     */
    public void gai_Id(Bq_Data Data){
        mDatabase = mSqliteHelper.getWritableDatabase();

        mDatabase.execSQL("update bqdata set id = '"+Data.getId()+"'where id = '"+(Data.getId() + 1)+"'");

        mDatabase.close();

    }
}
