package com.testleancould.dodo.lifecycledemo.step2;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

import com.testleancould.dodo.lifecycledemo.R;

import java.sql.Time;

import androidx.lifecycle.ViewModelProviders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ChronometerActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity2_chromometer);

        ChronometerViewmodel chronometerViewModel
                = ViewModelProviders.of(this).get(ChronometerViewmodel.class);

        Chronometer chronometer=findViewById(R.id.chonometer2);

        if (chronometerViewModel.getmStartTime()==null)
        {
            Long startTime= SystemClock.elapsedRealtime();
            Log.i("time:", startTime.toString());
            chronometerViewModel.setmStartTime(startTime);
            chronometer.setBase(startTime);
            Log.i("adam","11111");

        }else
            {
                chronometer.setBase(chronometerViewModel.getmStartTime());

            }

        Log.i("dog","22222");
            chronometer.start();
    }
}
