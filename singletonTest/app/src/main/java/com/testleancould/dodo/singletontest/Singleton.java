package com.testleancould.dodo.singletontest;

import javax.xml.validation.Validator;

/**
 * Created by adamDeng on 2019/9/12
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */


/*public class Singleton {
//赖汉式(没有同步线程不安全)
    private static Singleton singleton=null;
    private  Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if (singleton==null)
        {
            singleton=new Singleton();

        }
        return singleton;
    }

    //懒汉式（线程同步，安全的）
    private volatile static Singleton singleton=null;
    //私有的构造函数
    private Singleton()
    {

    }
    //公有的静态函数，对外暴露获取单例对象的接口
    public static Singleton getInstance()
    {
        if (singleton==null)
        {
            synchronized (Singleton.class)
            {
                if (singleton==null)
                {
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }


}*/


/*
//使用静态内部类实现
public class Singleton
{
    private static class SingleHoler
    {
//          静态初始化器，由JVM保证线程安全

        private static Singleton singleton=new Singleton();
    }

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        return SingleHoler.singleton;
    }

}
*/

/*//使用枚举来实现
public enum  Singleton
{
    uinqueSingleton;//定义一个枚举元素，相当于singleton实例

    public void singletonOperation()
    {
        System.err.println("功能输出");
    }


}*/

public class Singleton
{
    private static Singleton singleton=new Singleton();

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        return singleton;
    }
}