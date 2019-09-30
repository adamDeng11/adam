package com.testleancould.dodo.datademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.testleancould.dodo.datademo.ui.IoActivity;
import com.testleancould.dodo.datademo.ui.SharedpreferenceActivity;
import com.testleancould.dodo.datademo.ui.SqlActivity;

public class MainActivity extends AppCompatActivity {

    Button sharedBtn;
    Button ioBtn;
    Button sqlBtn;
    Button contBtn;
    Button webbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedBtn=findViewById(R.id.btn_shared);
        sharedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, SharedpreferenceActivity.class);
                startActivity(intent1);

            }
        });

        ioBtn=findViewById(R.id.btn_io);
        ioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this, IoActivity.class);
                startActivity(intent2);
            }
        });

        sqlBtn=findViewById(R.id.btn_sql);
        sqlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, SqlActivity.class);
                startActivity(intent3);

            }
        });




    }
}
