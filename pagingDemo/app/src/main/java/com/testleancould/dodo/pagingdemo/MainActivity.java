package com.testleancould.dodo.pagingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.testleancould.dodo.pagingdemo.adapter.TimeAdapter;
import com.testleancould.dodo.pagingdemo.bean.Message;
import com.testleancould.dodo.pagingdemo.bean.RetrofitService;
import com.testleancould.dodo.pagingdemo.viewmodel.MessageViewModel;

import java.util.ArrayList;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private RetrofitService retrofitService;
    private Button requestBtn;
    private RecyclerView recyclerView;
    private TimeAdapter timeAdapter;
    private ArrayList<Message.ResultBean> data=new ArrayList<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title=findViewById(R.id.title_text);
        imageView=findViewById(R.id.image);
        recyclerView=findViewById(R.id.recycle_show);

        timeAdapter=new TimeAdapter();
        MessageViewModel viewModel =ViewModelProviders.of(this).get(MessageViewModel.class);

        viewModel.getPagedListLiveData().observe(this, new Observer<PagedList<Message.ResultBean>>() {
            @Override
            public void onChanged(PagedList<Message.ResultBean> resultBeans) {
                timeAdapter.submitList(resultBeans);
            }
        });



        recyclerView.setAdapter(timeAdapter);

        //设置布局管理器

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
       /* Retrofit retrofit=new Retrofit.Builder()//创建Retrofit实例
                .baseUrl("https://api.apiopen.top/") //这里需要传入url的域名部分
                .addConverterFactory(GsonConverterFactory.create())//返回的数据经过转换工厂转换成我们想要的数据，最常用的就是Gson
                .build();*/

       /* retrofitService=retrofit.create(RetrofitService.class);//请求接口*/
        requestBtn=findViewById(R.id.btn_request);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://p1.pstatp.com/large/166200019850062839d3";
                Glide.with(getApplicationContext()).load(url).into(imageView);

            }
        });
    }

    /*public void request()
    {
        Observable<Message> call=retrofitService.getMessage(1,100);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {

                Message message=response.body();
                data.addAll(message.getResult());
                timeAdapter=new TimeAdapter();
                recyclerView.setAdapter(timeAdapter);



                if(response.body().getResult().size()>0)
                {

                title.setText(response.body().getResult().get(0).getName());
                Log.i("name","aaaaaa");}
                else
                    {
                        Toast.makeText(MainActivity.this,"内容不存在",Toast.LENGTH_LONG).show();
                    }

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                String errorMessage=t.getMessage();

                Toast.makeText(MainActivity.this,"请求失败"+errorMessage,Toast.LENGTH_LONG).show();

            }
        });
    }*/


}
