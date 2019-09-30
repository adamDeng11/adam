package com.testleancould.dodo.wanzitest.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Created by adamDeng on 2019/9/17
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class SampleTitleBehavior extends CoordinatorLayout.Behavior<View> {

    // 列表顶部和title底部重合时，列表的滑动距离。
    private int deltaY;
    private int y;

    public SampleTitleBehavior()
    {

    }

    public SampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (y==0)
        {
            y=dependency.getBottom();
        }

        deltaY=dependency.getBottom();




        System.out.println(deltaY);

            switch (deltaY)
            {
                case 1125 :

                    child.setAlpha(0);
                    break;


                default:

                    child.setAlpha(1f);
                    break;




            }



        /*float dy = dependency.getY() - child.getHeight();
        if (dy<deltaY)
        {
            float alpha=1;
            child.setAlpha(alpha);

        }*/
       /* float y = -(dy / deltaY) * child.getHeight();
        child.setTranslationY(y);*/

        /*float alpha = 1-(dy / deltaY);
        child.setAlpha(alpha);*/






        return true;
    }

}
