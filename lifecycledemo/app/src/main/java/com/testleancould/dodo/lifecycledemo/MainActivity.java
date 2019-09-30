package com.testleancould.dodo.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.testleancould.dodo.lifecycledemo.step1.ChronometerActivity1;
import com.testleancould.dodo.lifecycledemo.step2.ChronometerActivity2;
import com.testleancould.dodo.lifecycledemo.step3.ChronometerActivity3;
import com.testleancould.dodo.lifecycledemo.step4.LifecycleActivity4;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, ChronometerActivity1.class);
                startActivity(intent1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this, ChronometerActivity2.class);
                startActivity(intent2);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, ChronometerActivity3.class);
                startActivity(intent3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(MainActivity.this, LifecycleActivity4.class);
                startActivity(intent4);

            }
        });

    }
}
