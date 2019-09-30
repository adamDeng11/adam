package com.testleancould.dodo.wanzitest.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by adamDeng on 2019/9/18
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */

//bean一定要小写，其实包名也要规范小写
public class UserBean extends BaseObservable {
    //使用 @Bindable 注解实现双向绑定
        @Bindable
        private String name; //姓名
    @Bindable
        private int age; //年龄

        public UserBean(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public UserBean(){}


        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {

            this.name = name;
            notifyPropertyChanged(BR.name);



        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

}
