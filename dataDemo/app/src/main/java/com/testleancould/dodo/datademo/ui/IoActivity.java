package com.testleancould.dodo.datademo.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.testleancould.dodo.datademo.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import androidx.appcompat.app.AppCompatActivity;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class IoActivity extends AppCompatActivity {

    Button ioRead;
    Button ioWrite;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_io);
        ioWrite=findViewById(R.id.io_write);
        ioRead=findViewById(R.id.io_read);

        ioWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write("adam");
            }
        });

        ioRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read("adam");
            }
        });


    }

    //文件读
    private void write(String content)
    {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))//如果SD卡存在
        {
            File file=new File(Environment.getExternalStorageDirectory().toString()+File.separator+"DIR"+File.separator+"FILENAME");
            if (!file.getParentFile().exists())
            {
                file.getParentFile().mkdirs();
            }
            PrintStream out=null;
            try {
                out=new PrintStream(new FileOutputStream(file,true));

            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {
                if (out!=null)
                {
                    out.close();

                }
            }

        }else
            {
                Toast.makeText(this,"保存失败，SD卡不存在",Toast.LENGTH_LONG).show();
            }

    }

    private String read(String content)
    {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            File file=new File(Environment.getExternalStorageDirectory().toString()+File.separator+"DIR"+File.separator+"FILENAME");
            if (file.getParentFile().exists())
            {
                file.getParentFile().mkdirs();

            }
            Scanner scanner=null;
            StringBuilder stringBuilder=new StringBuilder();
            try {
                while (scanner.hasNext())
                {
                    stringBuilder.append(scanner.next()+"\n");
                    return stringBuilder.toString();
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {
                scanner.close();
            }
        }else{
            Toast.makeText(this,"读取失败",Toast.LENGTH_LONG).show();
        }
          return null;
    }
}
