package com.suozhang.rentaluser.common.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/3/2 14:03
 */
public class InitViewPager extends ViewPager {

    public InitViewPager(@NonNull Context context) {
        super(context);
    }

    public InitViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item, false);
    }
}
