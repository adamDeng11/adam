package com.testleancould.dodo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by adamDeng on 2019/9/9
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Intent intent2=getIntent();
        String name2=intent2.getStringExtra("name2");

        TextView textView=(TextView)findViewById(R.id.searchView);
        textView.setText(name2);
        textView.setSelected(true);

        Button searchButton=(Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });



    }
}
