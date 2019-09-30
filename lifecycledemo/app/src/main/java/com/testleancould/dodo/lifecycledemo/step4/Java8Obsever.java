package com.testleancould.dodo.lifecycledemo.step4;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Java8Obsever implements DefaultLifecycleObserver {
    private final static String Tag=Java8Obsever.class.getSimpleName();


    @Override
    public void onCreate(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onCreate");
    }
    @Override
    public void onStart(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onStart");
    }
    @Override
    public void onResume(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onResume");
    }
    @Override
    public void onPause(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onPause");
    }
    @Override
    public void onStop(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onStop");
    }
    @Override
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner){
        Log.i("Tag","onDestroy");
    }

}
