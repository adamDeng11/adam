package com.testleancould.dodo.datademo.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.testleancould.dodo.datademo.database.ContentOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by adamDeng on 2019/9/21
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class StudentContentProvider extends ContentProvider {

    private final static String TAG = "StudentProvider";

    private final static String AUTHORITY = "com.android.peter.provider";
    private final static int STUDENT_URI_CODE = 0;

    private Context mContext;
    private SQLiteDatabase mDataBase;
    private final static UriMatcher sUriMatcher;


    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY,"student",STUDENT_URI_CODE);
    }

    @Override
    public boolean onCreate() {
        mContext = getContext();
        mDataBase = new ContentOpenHelper(mContext).getWritableDatabase();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int uriType = sUriMatcher.match(uri);
        /*其中uri用于指定哪一个数据源，当一个数据源含有多个内容（比如多个表），就需要用不同的Uri进行区分*/
        /*(当调用UriMatch的match（uri）方法后，会返回uri匹配成功后返回的code码，如果没有匹配match方法将返回-1即UriMatcher.NO_MATCH)没设置code为0*/
        Cursor cursor;
        switch (uriType) {
            case STUDENT_URI_CODE:
                cursor = mDataBase.query(ContentOpenHelper.DATABASE_STUDENT_TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder,null);
                break;
            default:
                throw new IllegalArgumentException("UnSupport Uri : " + uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        int uriType = sUriMatcher.match(uri);
        long row;

        switch (uriType) {
            case STUDENT_URI_CODE:
                row = mDataBase.insert(ContentOpenHelper.DATABASE_STUDENT_TABLE_NAME,null, values);
                break;
            default:
                throw new IllegalArgumentException("UnSupport Uri : " + uri);
        }

        if(row > -1) {
            mContext.getContentResolver().notifyChange(uri,null);
            return ContentUris.withAppendedId(uri, row);
        }

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int uriType = sUriMatcher.match(uri);
        int rowDelete;

        switch (uriType) {
            case STUDENT_URI_CODE:
                rowDelete = mDataBase.delete(ContentOpenHelper.DATABASE_STUDENT_TABLE_NAME,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("UnSupport Uri : " + uri);
        }

        if(rowDelete > 0) {
            mContext.getContentResolver().notifyChange(uri,null);
        }

        return rowDelete;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int uriType = sUriMatcher.match(uri);
        int rowUpdate;
        switch (uriType) {
            case STUDENT_URI_CODE:
                rowUpdate = mDataBase.update(ContentOpenHelper.DATABASE_STUDENT_TABLE_NAME,values,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("UnSupport Uri : " + uri);
        }

        if(rowUpdate > 0) {
            mContext.getContentResolver().notifyChange(uri,null);
        }

        return rowUpdate;
    }

}
