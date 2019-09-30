package com.testleancould.dodo.pagingdemo.bean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public interface RetrofitService {

    @POST("getJoke")
    @FormUrlEncoded
    Observable<Message> getMessage(@Field("page") int page, @Field("count") int count);


}
