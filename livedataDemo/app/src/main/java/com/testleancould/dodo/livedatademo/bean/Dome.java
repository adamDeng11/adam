package com.testleancould.dodo.livedatademo.bean;

import android.widget.TextView;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Dome {
    private String phone_str;
    private String pwd_str;

    public Dome(String phone_str, String pwd_str) {
        this.phone_str = phone_str;
        this.pwd_str = pwd_str;
    }

    public Dome() {
    }

    public String getPhone_str() {
        return phone_str;

    }

    public void setPhone_str(String phone_str) {
        this.phone_str = phone_str;
    }

    public String getPwd_str() {
        return pwd_str;
    }

    public void setPwd_str(String pwd_str) {
        this.pwd_str = pwd_str;
    }

}
