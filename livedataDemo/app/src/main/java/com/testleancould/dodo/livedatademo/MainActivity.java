package com.testleancould.dodo.livedatademo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.testleancould.dodo.livedatademo.bean.Dome;
import com.testleancould.dodo.livedatademo.ui.main.MainFragment;
import com.testleancould.dodo.livedatademo.ui.main.MainFragment2;
import com.testleancould.dodo.livedatademo.ui.main.MainFragment3;
import com.testleancould.dodo.livedatademo.ui.main.MainViewModel;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn3)
    private Button btn3;
    /*@BindView(R.id.number3_txt)*/
    private TextView numbertxt;
    /*@BindView(R.id.password3_txt)*/
    private TextView passwordtxt;
    private MainViewModel viewModel;
    private Button jumpRoom;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            //添加fragment要注意在主布局什么位置引用。
            getSupportFragmentManager().beginTransaction().replace(R.id.fra1, new MainFragment()).commitNow();
            getSupportFragmentManager().beginTransaction().replace(R.id.fra2, new MainFragment2()).commitNow();


        }
        ButterKnife.bind(this);
        numbertxt=findViewById(R.id.number3_txt);
        passwordtxt=findViewById(R.id.password3_txt);
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        jumpRoom=findViewById(R.id.jump_room);

        //更改数据
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getDomeMutableLiveData().postValue(new Dome("1234567","adam"));

            }
        });

        //获取上面更新的数据，其实是观察数据是否变化以进行更新
        viewModel.getDomeMutableLiveData().observe(this, new Observer<Dome>() {
            @Override
            public void onChanged(Dome dome) {
                numbertxt.setText(dome.getPhone_str());
                passwordtxt.setText(dome.getPwd_str());
            }
        });




    }
    public void jumpClick(View view)
    {

        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
