package com.testleancould.dodo.datademo.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adamDeng on 2019/9/21
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ContentOpenHelper extends SQLiteOpenHelper {
    private final static String TAG = "ContentOpenHelper";

    private final static String DATABASE_NAME = "com_android_peter_provider.db";
    public final static String DATABASE_STUDENT_TABLE_NAME = "student";
    private final static int DATABASE_VERSION = 1;

    private Context mcontext;

    //建表
    private final static String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS "
            + DATABASE_STUDENT_TABLE_NAME
            + "(id INTEGER PRIMARY KEY,"
            + "name  VARCHAR(20) NOT NULL,"
            + "gender BIT DEFAULT(1),"
            + "number  VARCHAR(12) NOT NULL,"
            + "score INTEGER CHECK(score >= 0 and score <= 100))";


    public ContentOpenHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.mcontext=context;

    }

    public ContentOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        mcontext = context;
    }

    public ContentOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler);
        mcontext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade o = " + oldVersion + " , n = " + newVersion);
    }




}
