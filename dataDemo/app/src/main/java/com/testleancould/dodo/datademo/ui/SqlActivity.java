package com.testleancould.dodo.datademo.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.testleancould.dodo.datademo.Adapter.StudentAdapter;
import com.testleancould.dodo.datademo.MainActivity;
import com.testleancould.dodo.datademo.R;
import com.testleancould.dodo.datademo.bean.Student;
import com.testleancould.dodo.datademo.database.MyOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by adamDeng on 2019/9/20
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class SqlActivity extends AppCompatActivity {
    private Button addBtn;
    private Button delBtn;
    private Button queryBtn;
    private Button altBtn;
    private ListView listView;
    private EditText nameEdt;
    private EditText ageEdt;
    private EditText inputEdt;
    private List<Student> datas =new ArrayList<>();
    private StudentAdapter studentAdapter;
    private MyOpenHelper myOpenHelper;
    private Cursor cursor;
    private int Id=0;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sql);

        queryBtn=findViewById(R.id.sql_query);
        addBtn=findViewById(R.id.sql_add);
        delBtn=findViewById(R.id.sql_del);
        altBtn=findViewById(R.id.sql_alt);
        listView=findViewById(R.id.sql_listView);
        nameEdt=findViewById(R.id.sql_edt1);
        ageEdt=findViewById(R.id.sql_edt2);
        inputEdt=findViewById(R.id.sql_input);

        String[] strs=new String[]{"studentName","age"};
        myOpenHelper=new MyOpenHelper(this);
        cursor=myOpenHelper.select();
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(this,R.layout.lv_item,cursor,strs,new int[]{R.id.lv_name,R.id.lv_age});
        listView.setAdapter(simpleCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);          // 将cursor移到所点击的值
                Id = cursor.getInt(0);                // 取得字段_id的值
                nameEdt.setText(cursor.getString(1));
                ageEdt.setText(cursor.getString(2));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRec();
            }
        });
        altBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editRec();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRec();
            }
        });
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryRec();
            }
        });


    }

    private void addRec() {
        if (nameEdt.getText().toString().equals(""))
            return;
        myOpenHelper.insert(nameEdt.getText().toString(), ageEdt.getText().toString());
        //重新加载数据
        cursor.requery();
        listView.invalidateViews();
        nameEdt.setText("");
        ageEdt.setText("");

    }

    // 修改记录
    private void editRec() {
        if (nameEdt.getText().toString().equals(""))
            return;
        myOpenHelper.update(Id, nameEdt.getText().toString(), ageEdt.getText().toString());
        //重新加载数据
        cursor.requery();
        listView.invalidateViews();
        nameEdt.setText("");
        ageEdt.setText("");


    }

    //删除记录
    private void deleteRec() {
        myOpenHelper.delete(Id);
        cursor.requery();
        listView.invalidateViews();
        nameEdt.setText("");
        ageEdt.setText("");
    }

    //根据名字查询
    private void queryRec() {
        String et = inputEdt.getText().toString();
        String args[] = new String[]{"%" + et + "%"};
        cursor = myOpenHelper.query(args);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.lv_item,
                cursor,
                new String[]{"studentName", "age"},
                new int[]{R.id.lv_name, R.id.lv_age}
        );
        listView.setAdapter(adapter);
    }


}
