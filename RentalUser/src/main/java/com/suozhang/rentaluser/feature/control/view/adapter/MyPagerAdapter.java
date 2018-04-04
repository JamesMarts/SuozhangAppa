package com.suozhang.rentaluser.feature.control.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/11 13:39
 */
public class MyPagerAdapter extends PagerAdapter {
    private List<View> mViewList;

    public MyPagerAdapter(List<View> mViewList) {
        this.mViewList = mViewList;

    }

    @Override
    public int getCount() {
        return mViewList.size();//页卡数
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//官方推荐写法
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try {
            if (mViewList.get(position).getParent() == null) {
                ((ViewPager) container).addView(mViewList.get(position), 0);
            }
        } catch (Exception e) {
// TODO Auto-generated catch block	e.printStackTrace();
        }

        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));//删除页卡
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }
}

