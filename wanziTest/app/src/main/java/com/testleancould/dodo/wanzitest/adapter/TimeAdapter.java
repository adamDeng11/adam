package com.testleancould.dodo.wanzitest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.testleancould.dodo.wanzitest.R;
import com.testleancould.dodo.wanzitest.Time;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
/*
public class TimeAdapter extends ArrayAdapter<Time> {
    private int resourceId;
    public TimeAdapter(Context context, int resource, List<Time> objects)
    {
        super(context,resource,objects);
        resourceId=resource;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Time time=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        ((ImageView)view.findViewById(R.id.oval)).setImageResource(time.getOval());
        ((ImageView) view.findViewById(R.id.line_normal)).setImageResource(time.getLineId());
        ((TextView) view.findViewById(R.id.time)).setText(time.getTime());
        ((TextView) view.findViewById(R.id.title)).setText(time.getTitle());
        ((ImageView) view.findViewById(R.id.image)).setImageResource(time.getImageId());



        return view;
    }
}*/


public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.VH>{
    //② 创建ViewHolder

    public static class VH extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView time;
        private ImageView oval;
        private ImageView line;
        private ImageView image;
        private TextView play_txt;
        private ImageView play_img;

        public VH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            time = (TextView) itemView.findViewById(R.id.time_show);
            oval=(ImageView)itemView.findViewById(R.id.oval);
            line=(ImageView)itemView.findViewById(R.id.line_normal);
            image=(ImageView)itemView.findViewById(R.id.image_show);
            play_txt = (TextView) itemView.findViewById(R.id.play_txt);
            play_img=(ImageView)itemView.findViewById(R.id.paly_img);

        }
    }
    private Context context;
    private ArrayList<Time> datas;

    //创建构造函数
    public TimeAdapter(Context context, ArrayList<Time> datas) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.datas = datas;//实体类数据ArrayList
    }


    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {

        Time time=datas.get(position);
        holder.title.setText(time.getTitle());
        holder.time.setText(time.getTime());
        holder.oval.setImageResource(time.getOval());
        holder.line.setImageResource(time.getLineId());
        holder.image.setImageResource(time.getImageId());
        holder.play_img.setImageResource(time.getPlay_img());
        holder.play_txt.setText(time.getPlay_txt());


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
//        View itemView = View.inflate(context, R.layout.lv_item, null);
        View itemView = LayoutInflater.from(context).inflate(R.layout.lv_item,parent,false);
        return new VH(itemView);
   }
}
