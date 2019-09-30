package com.testleancould.dodo.lifecycledemo.step2;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

/**
 * Created by adamDeng on 2019/9/23
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ChronometerViewmodel extends ViewModel {
    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getmStartTime() {
        return mStartTime;
    }
@Nullable
    public void setmStartTime(Long mStartTime) {
        this.mStartTime = mStartTime;
    }




}
