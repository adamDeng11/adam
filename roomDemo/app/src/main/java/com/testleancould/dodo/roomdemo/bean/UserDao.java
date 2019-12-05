package com.testleancould.dodo.roomdemo.bean;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
//Dao实现数据库的具体操作，如增删改查
@Dao
public interface UserDao {

    /*query*/
    @Query("SELECT * FROM user")
    List<User> getAll();

    //in可以根据多个字段查询，如in (:a,b,c)
    @Query("select * from user where uid in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("select * from user where first_name like :first and last_name like :last")
    User findByName(String first,String last);

    @Query("select * from user where uid like :uid ")
    User findByUid(int uid);


    /*insert*/
    // OnConflictStrategy.REPLACE表示如果已经有数据，那么就覆盖掉
    //数据的判断通过主键进行匹配，也就是uid，非整个user对象
    //返回Long数据表示，插入条目的主键值（uid）
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    Long insert(User user);

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... users);
    /*注意这里 User...*/

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<User> users);


    /*update*/
    //更新已有数据，根据主键（uid）匹配，而非整个user对象
    //返回类型int代表更新的条目数目，而非主键uid的值。
    //表示更新了多少条目
    @Update
    int update(User user);

    @Update
    int updateAll(User user);

    @Update
    int updateAll(List<User> users);


    /*delete*/
    //删除user数据，数据的匹配通过主键uid实现。
    //返回int数据表示删除了多少条。非主键uid值。
    @Delete
    int delete(User user);

    @Query("delete from user")
    void deleteAll();

    @Delete
    int deleteAll(List<User> users);

}

