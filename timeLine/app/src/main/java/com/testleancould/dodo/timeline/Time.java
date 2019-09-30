package com.testleancould.dodo.timeline;

/**
 * Created by adamDeng on 2019/9/11
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Time {
    private String name;
    private int imageId;
    private int lineId;
    private String title;

    public String getTitle()
    {
        return title;
    }

    public String getName()
    {
        return name;
    }
   /* public void setName(String name)
    {
        this.name=name;
    }*/

    public Time(String title, String name, int imageId, int lineId)
    {
        this.title=title;
        this.name=name;
        this.imageId=imageId;
        this.lineId=lineId;



    }

    public int getImageId()
    {
        return imageId;
    }

    public int getLineId()
    {
        return lineId;
    }
    /*public void setImagId(int imagId)
    {
        this.imageId=imagId;

    }*/
}
