package com.testleancould.dodo.wanzitest;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Time {
    private String time;
    private String title;
    private int imageId;
    private int ovalId;
    private int lineId;
    private String play_txt;
    private int play_img;


    public String getPlay_txt()
    {
        return play_txt;
    }
    public int getPlay_img()
    {
        return play_img;
    }

    public String getTime()
    {
        return time;
    }

    public String getTitle()
    {
        return title;
    }
    public int getOval()
    {
        return ovalId;
    }

    public int getImageId()
    {
        return imageId;
    }

    public int getLineId()
    {
        return lineId;
    }

    public Time(String play_txt)
    {

        this.play_txt = play_txt;
    }

    public Time(String time,String play_txt,int play_img,String title,int imageId,int ovalId,int lineId)
    {
        this.play_txt=play_txt;
        this.play_img=play_img;
        this.time=time;
        this.title=title;
        this.imageId=imageId;
        this.ovalId=ovalId;
        this.lineId=lineId;



    }



}