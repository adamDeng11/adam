package com.testleancould.dodo.datademo.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.testleancould.dodo.datademo.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class SharedpreferenceActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText sharedEdt;
    private Button saveBtn;
    private Button readBtn;
    private TextView sharedShow;


    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sharedpreference);

        sharedEdt=findViewById(R.id.share_edt);
        saveBtn=findViewById(R.id.save_btn);
        readBtn=findViewById(R.id.read_btn);
        sharedShow=findViewById(R.id.shared_show);
        sharedPreferences=getSharedPreferences("test", MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",sharedEdt.getText().toString());
                editor.commit();

            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedShow.setText(sharedPreferences.getString("name",""));

            }
        });




    }


}
