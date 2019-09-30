package com.testleancould.dodo.pagingdemo.viewmodel;

import android.view.View;

import com.testleancould.dodo.pagingdemo.bean.Message;
import com.testleancould.dodo.pagingdemo.data.MessageFactory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

/**
 * Created by adamDeng on 2019/9/29
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MessageViewModel extends ViewModel {
    private final LiveData<PagedList<Message.ResultBean>> pagedListLiveData;
    private DataSource<Integer,Message.ResultBean> dataSource;

    public MessageViewModel() {
        MessageFactory messageFactory=new MessageFactory();
        dataSource=messageFactory.create();
        pagedListLiveData=new LivePagedListBuilder<>(messageFactory,20).build();

    }

    public void invalidateDataSource() {
        dataSource.invalidate();
    }
    public LiveData<PagedList<Message.ResultBean>> getPagedListLiveData(){return pagedListLiveData;}
}
