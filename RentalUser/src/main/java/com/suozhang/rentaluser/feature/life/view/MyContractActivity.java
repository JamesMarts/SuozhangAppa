package com.suozhang.rentaluser.feature.life.view;

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

public class MyContractActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tbl_order)
    TabLayout mTblOrder;
    @BindView(R.id.vp_order)
    ViewPager mVpOrder;
    private String[] titles = {"进行中", "已结束"};
    private List<Fragment> list;
    private MyFragmentAdapter adapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_contract;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, "我的合同", true, true);

    }

    @Override
    protected void initData() {
        inits();
    }


    private void inits() {
        //页面，数据源
        list = new ArrayList<>();
        list.add(new ContractingFragment());
        list.add(new ContractedFragment());

        //ViewPager的适配器
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), list);
        mVpOrder.setAdapter(adapter);
        //绑定
        mTblOrder.setupWithViewPager(mVpOrder);
        //mTblOrder.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器
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
