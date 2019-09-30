package com.testleancould.dodo.datademo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "School";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "Student";

//创建数据库
    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
//建表
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME+"(_id integer primary key autoincrement, studentName char(10), age char(20))");
        System.out.println("创建数据库");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public Cursor select() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
//增加
    public long insert(String studentName,String age ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("studentName", studentName);
        cv.put("age", age);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }
//删除
    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where ="_id = ?";
        String[] whereValue = { Integer.toString(id) };
        db.delete(TABLE_NAME, where, whereValue);
    }
    //根据条件查询
    public Cursor query(String[] args) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE studentName LIKE ?", args);
        return cursor;
    }

    //更新记录
    public void update(int id, String studentName,String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "_id = ?";
        String[] whereValue = { Integer.toString(id) };
        ContentValues cv = new ContentValues();
        cv.put("studentName", studentName);
        cv.put("age", age);
        db.update(TABLE_NAME, cv, where, whereValue);
    }
}
