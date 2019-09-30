package com.testleancould.dodo.pagingdemo.data;

import com.testleancould.dodo.pagingdemo.bean.Message;

import java.util.Date;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

/**
 * Created by adamDeng on 2019/9/29
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class MessageFactory extends DataSource.Factory<Integer, Message.ResultBean> {

    private MutableLiveData<MessageDataSource> mutableLiveData=new MutableLiveData<>();

    @Override
    public DataSource<Integer,Message.ResultBean> create()
    {
        MessageDataSource messageDataSource=new MessageDataSource();
        mutableLiveData.postValue(messageDataSource);
        return messageDataSource;
    }
}
