package com.testleancould.dodo.wanzitest.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.testleancould.dodo.wanzitest.R;
import com.testleancould.dodo.wanzitest.bean.UserBean;
import com.testleancould.dodo.wanzitest.databinding.ActivityMvvmBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * Created by adamDeng on 2019/9/18
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MvvmActivty extends AppCompatActivity {
    ActivityMvvmBinding activityMvvmBinding;
    UserBean userBean;
    String result;
    EditText editText;
    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        activityMvvmBinding= DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        userBean=new UserBean("adam",11);
        activityMvvmBinding.setUser(userBean);
        activityMvvmBinding.setActivity(this);
    }


    public void onclick(View view)
    {
        Toast.makeText(this,"你点击了",Toast.LENGTH_LONG).show();
        userBean.setAge(userBean.getAge()+1);
        /*editText=(EditText)findViewById(R.id.edit);
        result=editText.getText().toString();
        userBean.setName(result);*/
        activityMvvmBinding.setUser(userBean);

    }
}
