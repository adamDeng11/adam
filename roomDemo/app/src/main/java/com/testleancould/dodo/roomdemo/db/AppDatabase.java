package com.testleancould.dodo.roomdemo.db;

import com.testleancould.dodo.roomdemo.bean.User;
import com.testleancould.dodo.roomdemo.bean.UserDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
//注解指定了database的表映射实体数据以及版本等信息
@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    //RoomDatabase提供直接访问底层数据库实现，我们通过定义抽象方法返回具体Dao
    //然后进行数据库增删该查的实现。
    public abstract UserDao userDao();

    //数据库变动添加Migration
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN age INTEGER NOT NULL DEFAULT 0");
        }
    };

}
