package com.testleancould.dodo.lifecycledemo.step3;

import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class LiveDataTimerViewModel extends ViewModel {
    private static final int ONE_SECOND = 1000;

    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();

    private long mInitialTime;

    public LiveDataTimerViewModel() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;

                // setValue() cannot be called from a background thread so post to main thread.
                mElapsedTime.postValue(newValue);
            }
        }, ONE_SECOND, ONE_SECOND);

    }

    @SuppressWarnings("unused")  // Will be used when step is completed
    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }
}
