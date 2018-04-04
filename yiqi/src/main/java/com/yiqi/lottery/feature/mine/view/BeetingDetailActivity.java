package com.yiqi.lottery.feature.mine.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

import java.util.ArrayList;
import java.util.List;

public class BeetingDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tvtablayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_beeting_detail;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "投注明细", true, true);

    }

    @Override
    protected void initData() {
        initViewPager();
    }

    private void initViewPager() {
        // 创建一个集合,装填Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        // 装填
        fragments.add(new BeetingListFragment());
        fragments.add(new BeetingListFragment());
        fragments.add(new BeetingListFragment());
        fragments.add(new BeetingListFragment());
        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        // 给ViewPager设置适配器
        mViewpager.setAdapter(myPagerAdapter);
        // TabLayout 指示器 (记得自己手动创建4个Fragment,注意是 app包下的Fragment 还是 V4包下的 Fragment)
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        // 使用 TabLayout 和 ViewPager 相关联
        mTabLayout.setupWithViewPager(mViewpager);
        // TabLayout指示器添加文本
        mTabLayout.getTabAt(0).setText("全部");
        mTabLayout.getTabAt(1).setText("中奖");
        mTabLayout.getTabAt(2).setText("待开奖");
        mTabLayout.getTabAt(3).setText("未成功");

    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public void setFragments(ArrayList<Fragment> fragments) {
            mFragmentList = fragments;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = mFragmentList.get(position);

            return fragment;
        }

        @Override
        public int getCount() {

            return mFragmentList.size();
        }
    }
}
