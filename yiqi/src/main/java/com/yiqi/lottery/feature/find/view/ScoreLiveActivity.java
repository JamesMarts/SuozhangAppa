package com.yiqi.lottery.feature.find.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;
import com.yiqi.lottery.feature.documentary.view.DocumentaryFragment;
import com.yiqi.lottery.feature.documentary.view.HallFragment;

import java.util.ArrayList;
import java.util.List;

public class ScoreLiveActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_find_basketball)
    TextView mBtnFindBasketball;
    @BindView(R.id.btn_find_football)
    TextView mBtnFindFootball;
    @BindView(R.id.tvtablayout)
    TabLayout mTabLayout;
    @BindView(R.id.tvviewpager)
    ViewPager mViewPager;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_score_live;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {
        initViewPager();
    }


    @Override
    protected void initView() {
        mBtnFindBasketball.setBackground(getResources().getDrawable(R.drawable.bg_find_score_left_select));
        initToolBar(mToolbar, "", true, true);
    }


    @OnClick({R.id.btn_find_basketball, R.id.btn_find_football})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_find_basketball:
                mBtnFindBasketball.setBackground(getResources().getDrawable(R.drawable.bg_find_score_left_select));
                mBtnFindFootball.setBackground(getResources().getDrawable(R.drawable.bg_find_score_left_unselect));
                break;
            case R.id.btn_find_football:
                mBtnFindBasketball.setBackground(getResources().getDrawable(R.drawable.bg_find_score_right_unselect));
                mBtnFindFootball.setBackground(getResources().getDrawable(R.drawable.bg_find_score_right_select));
                break;
        }
    }

    private void initViewPager() {
        // 创建一个集合,装填Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        // 装填
        fragments.add(new FindScoreListFragment());
        fragments.add(new FindScoreListFragment());
        fragments.add(new FindScoreListFragment());
        fragments.add(new FindScoreListFragment());

        // 创建ViewPager适配器
      MyPagerAdapter myPagerAdapter =new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        // 给ViewPager设置适配器
        mViewPager.setAdapter(myPagerAdapter);
        // TabLayout 指示器 (记得自己手动创建4个Fragment,注意是 app包下的Fragment 还是 V4包下的 Fragment)
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        // 使用 TabLayout 和 ViewPager 相关联
        mTabLayout.setupWithViewPager(mViewPager);
        // TabLayout指示器添加文本
        mTabLayout.getTabAt(0).setText("全部");
        mTabLayout.getTabAt(1).setText("进行中");
        mTabLayout.getTabAt(2).setText("未开场");
        mTabLayout.getTabAt(3).setText("完场");

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
