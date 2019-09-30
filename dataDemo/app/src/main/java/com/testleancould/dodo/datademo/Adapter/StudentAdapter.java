package com.testleancould.dodo.datademo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.testleancould.dodo.datademo.R;
import com.testleancould.dodo.datademo.bean.Student;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class StudentAdapter extends ArrayAdapter<Student> {

    private int resourceId;
    public StudentAdapter(Context context, int resource, List<Student> objects)
    {
        super(context,resource,objects);
        resourceId=resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Student student =getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        ((TextView) view.findViewById(R.id.lv_name)).setText(student.getName());
        ((TextView) view.findViewById(R.id.lv_age)).setText(student.getAge());

        return view;
    }
}
