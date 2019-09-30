package com.testleancould.dodo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/9
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");

        TextView textView=(TextView)findViewById(R.id.showView);
        textView.setText(name);
        textView.setSelected(true);



    }


}
