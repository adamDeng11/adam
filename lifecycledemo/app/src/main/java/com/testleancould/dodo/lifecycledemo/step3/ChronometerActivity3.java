package com.testleancould.dodo.lifecycledemo.step3;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.testleancould.dodo.lifecycledemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ChronometerActivity3 extends AppCompatActivity {
    private LiveDataTimerViewModel liveDataTimerViewModel;
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity3_chronometer);
        liveDataTimerViewModel= ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();

    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                String newText = ChronometerActivity3.this.getResources().getString(
                        R.string.seconds, aLong);
                ((TextView) findViewById(R.id.timer_textview)).setText(newText);
                Log.d("ChronometerActivity3", "Updating timer");
            }
        };

        //TODO: observe the ViewModel's elapsed time
    }
}
