package com.testleancould.dodo.lifecycledemo.step4;

import android.os.Bundle;

import com.testleancould.dodo.lifecycledemo.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class LifecycleActivity4 extends AppCompatActivity {
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity4_lifecycle);

        getLifecycle().addObserver(new Java8Obsever());

    }
}
