package com.testleancould.dodo.roomdemo.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
//Entity：具体的bean实体，会与数据库表column进行映射
@Entity(tableName = "user",indices = {})
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int uid;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "age")
    private int age;

   /* public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;*/

    //必须指定一个构造方法，room框架需要。并且只能指定一个
//，如果有其他构造方法，则其他的构造方法必须添加@Ignore注解

    public User(){}

    @Ignore
    public User(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Ignore
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    @Ignore
    public User(int uid)
    {
        this.uid=uid;
    }
    @Ignore
    public User(int uid, String firstName, String lastName, int age) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString()
    {
        return "名字:"+firstName+lastName+"年龄:"+age;

    }



}

