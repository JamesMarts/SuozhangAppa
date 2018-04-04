package com.suozhang.rentaluser.feature.user.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CollectionActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tbl_order)
    TabLayout mTblOrder;
    @BindView(R.id.vp_order)
    ViewPager mVpOrder;
    private String[] titles = {"生活", "发现"};
    private List<Fragment> list;
    private MyFragmentAdapter adapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "我的收藏", true, true);
    }

    @Override
    protected void initData() {
        //页面，数据源
        list = new ArrayList<>();
        list.add(new CollectionFragment());
        list.add(new CollectionFragment());

        //ViewPager的适配器
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), list);
        mVpOrder.setAdapter(adapter);
        //绑定
        mTblOrder.setupWithViewPager(mVpOrder);
    }
    public class MyFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;
        FragmentManager fragmentManager;

        public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.list = fragments;
            this.fragmentManager = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
