package com.testleancould.dodo.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
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

        Time time =getItem(position);
        View view;
        ViewHolder viewHolder;

        if(convertView==null)
        {
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.title=(TextView)view.findViewById(R.id.title);
            viewHolder.name=(TextView)view.findViewById(R.id.name);
            viewHolder.image=(ImageView)view.findViewById(R.id.image);
            viewHolder.line_normal=(ImageView)view.findViewById(R.id.line_normal);
            view.setTag(viewHolder);//保存

        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//取出
        }
        viewHolder.title.setText(time.getTitle());
        viewHolder.name.setText(time.getName());
        viewHolder.image.setImageResource(time.getImageId());
        viewHolder.line_normal.setImageResource(time.getLineId());

     return view;
    }
}
