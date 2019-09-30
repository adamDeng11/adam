package com.testleancould.dodo.pagingdemo.bean;

/**
 * Created by adamDeng on 2019/9/24
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class StudentModel {
    private int stuId;
    private String stuName;

    public StudentModel(int stuId,String stuName)
    {
        this.stuId=stuId;
        this.stuName=stuName;

    }



    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }




}
