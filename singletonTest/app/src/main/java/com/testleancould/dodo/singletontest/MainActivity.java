package com.testleancould.dodo.singletontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("main*()方法开始运行了");
        System.err.println("测试有什么区别");
        System.out.println("第一条");
        System.err.println("测试顺序使用");
        System.out.println("第二条");
        System.out.println("第三条");
        System.out.println("第四条");
        System.out.println("第五条");








    }
}
