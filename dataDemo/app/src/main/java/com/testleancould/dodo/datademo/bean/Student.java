package com.testleancould.dodo.datademo.bean;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Student {
    private String name;
    private String age;

    public Student(String name,String age)
    {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }





}
