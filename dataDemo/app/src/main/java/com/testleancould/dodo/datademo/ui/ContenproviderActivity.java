package com.testleancould.dodo.datademo.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.testleancould.dodo.datademo.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ContenproviderActivity extends AppCompatActivity {
    private final static String TAG = "ClientActivity";

    /**
     * student table
     * @id primary key
     * @name student's name. e.g:peter.
     * @gender student's gender. e.g: 0 male; 1 female.
     * @number student's number. e.g: 201804081702.
     * @score student's score. more than 0 and less than 100. e.g:90.
     * */
    private final static String AUTHORITY = "com.android.peter.provider";
    private final static Uri STUDENT_URI = Uri.parse("content://" + AUTHORITY + "/student");

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        mContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"------------insert---------");
        insertValue();
        queryValue();
        Log.d(TAG,"------------update---------");
        updateValue();
        queryValue();
        Log.d(TAG,"------------delete---------");
        deleteValue();
        queryValue();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void insertValue() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",0);
        contentValues.put("name","peter");
        contentValues.put("gender",0);
        contentValues.put("number","201804081705");
        contentValues.put("score","100");

        mContext.getContentResolver().insert(STUDENT_URI,contentValues);
    }

    private void queryValue() {
        Cursor cursor = getContentResolver().query(STUDENT_URI, new String[]{"id", "name","gender","number","score"},null,null,null);
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.id = cursor.getInt(cursor.getColumnIndex("id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.gender = cursor.getInt(cursor.getColumnIndex("gender"));
            student.number = cursor.getString(cursor.getColumnIndex("number"));
            student.score = cursor.getInt(cursor.getColumnIndex("score"));
            Log.d(TAG,"student = " + student.toString());
        }
    }

    private void updateValue() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",0);
        contentValues.put("name","update");
        contentValues.put("gender",1);
        contentValues.put("number","201804111048");
        contentValues.put("score","90");

        getContentResolver().update(STUDENT_URI,contentValues,"id = ?",new String[] {"0"});
    }

    private void deleteValue() {
        getContentResolver().delete(STUDENT_URI,"name = ?",new String[]{"update"});
    }
}
//student数据封装类
class Student {
    private final static String TAG = "Student";

    public Integer id;
    public String name;
    public Integer gender;
    public String number;
    public Integer score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }

}
