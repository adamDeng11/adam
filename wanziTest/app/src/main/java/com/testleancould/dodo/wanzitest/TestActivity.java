package com.testleancould.dodo.wanzitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.testleancould.dodo.wanzitest.R;
import com.testleancould.dodo.wanzitest.mvvm.MvvmActivty;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/18
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class TestActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test);


    }

public void Click(View view)
{
    switch (view.getId())
    {
        case R.id.btn1:
            Intent intent1=new Intent(this,MainActivity.class);
            startActivity(intent1);
        case R.id.btn2:
            Intent intent2=new Intent(this,ChannelActivity.class);
            startActivity(intent2);
        case R.id.btn3:
            Intent intent3=new Intent(this, MvvmActivty.class);
            startActivity(intent3);


    }


}


}
