package com.testleancould.dodo.pagingdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.testleancould.dodo.pagingdemo.R;
import com.testleancould.dodo.pagingdemo.bean.Message;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by adamDeng on 2019/9/29
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class TimeAdapter extends PagedListAdapter<Message.ResultBean, TimeAdapter.VH> {
    //② 创建ViewHolder

    public static class VH extends RecyclerView.ViewHolder{
        TextView name;
        TextView time;
        ImageView photo;


        public VH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_show);
            time = itemView.findViewById(R.id.time_show);
            photo=itemView.findViewById(R.id.photo_show);

        }
    }
    private Context context;
    private ArrayList<Message.ResultBean> datas;

    //创建构造函数
    public TimeAdapter() {
      /*  //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.datas = datas;//实体类数据ArrayList*/
      super(resultBeanItemCallback);
    }


    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(final VH holder, int position) {



        Message.ResultBean resultBean =getItem(position);
        holder.name.setText(resultBean.getName());
        holder.time.setText(resultBean.getPasstime());



       /* Glide.with(context)
                .load(resultBean.getHeader())
                .into(new Target<GlideDrawable>() {
                    @Override
                    public void onLoadStarted(Drawable placeholder) {
                        Log.i("aaa","错误图片");
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {

                    }

                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        holder.photo.setImageDrawable(resource);
                        Log.i("aaa","错误图片");
                    }

                    @Override
                    public void onLoadCleared(Drawable placeholder) {

                    }

                    @Override
                    public void getSize(SizeReadyCallback cb) {

                    }

                    @Override
                    public void setRequest(Request request) {

                    }

                    @Override
                    public Request getRequest() {
                        return null;
                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onStop() {

                    }

                    @Override
                    public void onDestroy() {

                    }
                });*/
      Glide.with(context).load(resultBean.getHeader())
        .into(holder.photo);

    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
//        View itemView = View.inflate(context, R.layout.lv_item, null);
        context = parent.getContext();


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new VH(itemView);
    }


    private static DiffUtil.ItemCallback<Message.ResultBean> resultBeanItemCallback=new DiffUtil.ItemCallback<Message.ResultBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull Message.ResultBean oldItem, @NonNull Message.ResultBean newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Message.ResultBean oldItem, @NonNull Message.ResultBean newItem) {
            return false;
        }
    };
}
