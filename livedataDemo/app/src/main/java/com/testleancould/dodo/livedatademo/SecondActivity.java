package com.testleancould.dodo.livedatademo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/25
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private StringBuffer mBuffer;
    private String TAG = "thedata";

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.second_activity);


    }

}
