package com.testleancould.dodo.roomdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testleancould.dodo.roomdemo.R;
import com.testleancould.dodo.roomdemo.bean.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
/*
public class MyAdapter extends PagedListAdapter<User, MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<User> datas;
    public static final DiffUtil.ItemCallback<User> mDiffCallback = new MyAdapter.VideoInfoItemCallback();

    //创建构造函数
    protected MyAdapter(Context context, ArrayList<User> datas) {
        super(mDiffCallback);
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.datas = datas;//实体类数据ArrayList
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
//        View itemView = View.inflate(context, R.layout.lv_item, null);
        View itemView = LayoutInflater.from(context).inflate(R.layout.iv_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {
        User data = getItem(position);


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView rv_txt;

        public MyViewHolder(View itemView) {
            super(itemView);

            rv_txt = itemView.findViewById(R.id.iv_txt);
            rv_txt.setTextColor(Color.RED);
        }
    }

    private static class VideoInfoItemCallback extends DiffUtil.ItemCallback<User>{
        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            return oldItem.getUrl() == newItem.getUrl();
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            return (oldItem==newItem);
        }
    }
}
*/
