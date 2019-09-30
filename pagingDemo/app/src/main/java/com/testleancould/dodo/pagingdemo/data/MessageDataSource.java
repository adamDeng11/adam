package com.testleancould.dodo.pagingdemo.data;

import com.testleancould.dodo.pagingdemo.bean.Bean;
import com.testleancould.dodo.pagingdemo.bean.Concert;
import com.testleancould.dodo.pagingdemo.bean.Message;
import com.testleancould.dodo.pagingdemo.bean.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adamDeng on 2019/9/29
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MessageDataSource extends PositionalDataSource<Message.ResultBean> {


    private final Retrofit retrofit=new Retrofit.Builder()//创建Retrofit实例
            .baseUrl("https://api.apiopen.top/") //这里需要传入url的域名部分
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())//返回的数据经过转换工厂转换成我们想要的数据，最常用的就是Gson
            .build();
    private final   RetrofitService mService;

    public MessageDataSource() {
        mService = retrofit.create(RetrofitService.class);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull final LoadInitialCallback<Message.ResultBean> callback) {

        fetchItem(0,params.pageSize, new MessageDataSource.Callback() {
            @Override
            public void onResult(Message value) {
                callback.onResult(value.getResult(), 0, 1000);
            }
        });


       /* callback.onResult(fetchItems(0, 20), 0, 50);*/
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull final LoadRangeCallback<Message.ResultBean> callback) {

        fetchItem(params.startPosition,params.loadSize, new MessageDataSource.Callback() {
            @Override
            public void onResult(Message value) {
                callback.onResult(value.getResult());
            }
        });
        /*callback.onResult(fetchItems(params.startPosition, params.loadSize));*/
    }


    private void fetchItem(final int startPosition,int size, final Callback callback)
    {
       mService.getMessage(startPosition,size).subscribe(new Observer<Message>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(Message value) {
               callback.onResult(value);
           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       });
    }


   /* private ArrayList<Message.ResultBean> fetchItems(int startPosition, int pageSize) {
        final ArrayList<Message.ResultBean> list = new ArrayList<>();

        for (int i = startPosition; i < startPosition + pageSize; i++) {

            Message.ResultBean resultBean=new Message.ResultBean();
            resultBean.setPasstime("passtime"+i);
            resultBean.setName("adam"+i);
            list.add(resultBean);
        }
        return list;
    }*/

    private interface Callback {

        void onResult(Message value);
    }

}
