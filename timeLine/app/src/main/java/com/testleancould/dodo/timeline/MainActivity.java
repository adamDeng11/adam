package com.testleancould.dodo.timeline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private List<Time> times =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        TimeAdapter timeAdapter =new TimeAdapter(MainActivity.this,R.layout.lv_item, times);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(timeAdapter);
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Time time=times.get(position);
                Toast.makeText(MainActivity.this, time.getName(), Toast.LENGTH_SHORT).show();

            }
        });





    }

    private void init() {
        times.add(new Time("2019过去","254天", R.drawable.point,R.color.colorAccent));
        times.add(new Time("我们相识","1111天", R.drawable.point,R.color.colorAccent));
        times.add(new Time("学习了吗","当然", R.drawable.point,R.color.colorAccent));
        times.add(new Time("毕业了吗","毕业了", R.drawable.point,R.color.colorAccent));
        times.add(new Time("距离生日","299天",R.drawable.point,R.color.colorAccent));
        times.add(new Time("虚度人生","7736天", R.drawable.point,R.color.colorAccent));
        times.add(new Time("很高兴认识你","我也是", R.drawable.point,R.color.colorAccent));

    }
}
