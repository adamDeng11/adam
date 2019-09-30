package com.testleancould.dodo.wanzitest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testleancould.dodo.wanzitest.adapter.TimeAdapter;
import com.testleancould.dodo.wanzitest.R;
import com.testleancould.dodo.wanzitest.Time;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ProgramFragment extends Fragment {

    private ArrayList<Time> data=new ArrayList<>();
//    private ListView listView;
    private RecyclerView recyclerView;
    private TimeAdapter timeAdapter;
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment3,container,false);


        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        timeAdapter=new TimeAdapter(getActivity(),data);
        recyclerView.setAdapter(timeAdapter);


        init();
        /*listView=(ListView)view.findViewById(R.id.listview);
        listView.setAdapter(new TimeAdapter(getActivity().getApplicationContext(),R.layout.lv_item,data));
        listView.setDivider(null);*/
        return view;



    }

    private void init()
    {

        for (int i=0;i<10;i++)
        {
            data.add(new Time("08:00 - 09:00","正在播放",R.mipmap.play,"小美告诉你健身的好处",R.mipmap.keep,R.drawable.point,R.color.white));

        }



    }
}
