package com.testleancould.dodo.wanzitest;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.testleancould.dodo.wanzitest.fragment.ActivityFragment;
import com.testleancould.dodo.wanzitest.fragment.CardFragment;
import com.testleancould.dodo.wanzitest.fragment.GameFragment;
import com.testleancould.dodo.wanzitest.fragment.ProgramFragment;
import com.testleancould.dodo.wanzitest.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


/**
 * Created by adamDeng on 2019/9/10
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class ChannelActivity extends AppCompatActivity {

    TabLayout myTab;

    List<String> mTitle;
    List<Fragment> mFragment;

    ActivityFragment activityFragment = new ActivityFragment();
    CardFragment cardFragment =new CardFragment();
    ProgramFragment programFragment=new ProgramFragment();
    GameFragment gameFragment=new GameFragment();
    ShopFragment shopFragment=new ShopFragment();
    Toolbar toolbar;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_channel);
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        myTab=(TabLayout)findViewById(R.id.mytab);
        /*myTab.addTab(myTab.newTab().setText("活动").setIcon(R.mipmap.ic_launcher));
        myTab.addTab(myTab.newTab().setText("卡卷").setIcon(R.mipmap.ic_launcher));
        myTab.addTab(myTab.newTab().setText("节目").setIcon(R.mipmap.ic_launcher));
        myTab.addTab(myTab.newTab().setText("游戏").setIcon(R.mipmap.ic_launcher));
        myTab.addTab(myTab.newTab().setText("店铺").setIcon(R.mipmap.ic_launcher));*/
       /* toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.post(new Runnable() {
            @Override
            public void run() {


            }
        });*/

        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTitle = new ArrayList<>();
        mTitle.add("活动");
        mTitle.add("卡卷");
        mTitle.add("节目");
        mTitle.add("游戏");
        mTitle.add("店铺");

        mFragment = new ArrayList<>();
        mFragment.add(activityFragment);
        mFragment.add(cardFragment);
        mFragment.add(programFragment);
        mFragment.add(gameFragment);
        mFragment.add(shopFragment);
        //添加的fragment一定要每个不同，不然会报错
        //添加的fragment一定要初始化

        viewPager=(ViewPager)findViewById(R.id.mViewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });


        viewPager.setOffscreenPageLimit(2);
         myTab.setupWithViewPager(viewPager);

    }
}
