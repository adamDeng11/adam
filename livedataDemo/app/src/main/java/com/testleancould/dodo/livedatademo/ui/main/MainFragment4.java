package com.testleancould.dodo.livedatademo.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.testleancould.dodo.livedatademo.R;
import com.testleancould.dodo.livedatademo.bean.Dome;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by adamDeng on 2019/9/25
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MainFragment4 extends Fragment {

    Button backBtn;


    public static MainFragment3 newInstance() {
        return new MainFragment3();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment4, container, false);
    }


    @Override
    public void onViewCreated(View view,@Nullable Bundle bundle)
    {
        super.onViewCreated(view,bundle);
        backBtn=view.findViewById(R.id.back_fra);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainFragment4_to_mainFragment32);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }
}