package com.suozhang.rentaluser.feature.control.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/11 13:39
 */
public class MyPagerButtomAdapter extends PagerAdapter {
    private List<View> mViewList;

    private List<String> mStringList;

    public MyPagerButtomAdapter(List<View> mViewList,List<String> mStringList) {
        this.mViewList = mViewList;
        this. mStringList=mStringList;
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
        // TODO Auto-generated method stub
        View v=mViewList.get(position);
        ViewGroup parent = (ViewGroup) v.getParent();
        //Log.i("ViewPaperAdapter", parent.toString());
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));//删除页卡
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList.get(position);//页卡标题
    }



}

