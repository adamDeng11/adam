package designMode;

import java.security.PublicKey;

/**
 * Created by adamDeng on 2019/9/18
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Client {

    public static void main(String[] args)
    {
        Icalculator icalculator=new add();
        Context context=new Context(icalculator);
        int result=context.Ical(1,2);
        System.out.println(result);

    }

    interface Icalculator
    {
       int Ical(int a,int b);


    }

    static class add implements Icalculator
    {
           @Override
            public int Ical(int a,int b)
        {
            return a+b;

        }

    }

    static class sub implements  Icalculator
    {
        @Override
        public  int Ical(int a,int b)
        {
            return a-b;
        }
    }

    static class Context
    {
        private Icalculator icalculator;

        public Context(Icalculator icalculator)
        {
            this.icalculator=icalculator;

        }

        public int Ical(int a,int b)
        {
            return this.icalculator.Ical(a,b);

        }

    }


}
