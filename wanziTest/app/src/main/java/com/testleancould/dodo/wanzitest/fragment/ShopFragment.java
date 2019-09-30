package com.testleancould.dodo.wanzitest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testleancould.dodo.wanzitest.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ShopFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment5,container,false);
        return view;
    }
}
