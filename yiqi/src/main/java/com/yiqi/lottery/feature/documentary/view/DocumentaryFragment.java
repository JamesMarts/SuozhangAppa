package com.yiqi.lottery.feature.documentary.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseFragment;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.enums.LotteryType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentaryFragment extends BaseFragment {


    @BindView(R.id.tvtablayout)
    TabLayout mTabLayout;
    @BindView(R.id.tvviewpager)
    ViewPager mViewPager;

    PopupWindow mPopupWindow;
    @BindView(R.id.btn_gendan)
    TextView btnGendan;

    @BindView(R.id.view_toolbar)
    RelativeLayout viewToolbar;
    @BindView(R.id.img_xiala)
    ImageView imgXiala;
    Unbinder unbinder;


    public int attachLayoutRes() {
        return R.layout.fragment_documentary;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void onStart() {
        super.onStart();
        initViewPager();
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {

    }

    private void initViewPager() {
        // 创建一个集合,装填Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        // 装填
        fragments.add(new HallFragment());
        fragments.add(new HallFragment());
        fragments.add(new HallFragment());

        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        myPagerAdapter.setFragments(fragments);
        // 给ViewPager设置适配器
        mViewPager.setAdapter(myPagerAdapter);
        // TabLayout 指示器 (记得自己手动创建4个Fragment,注意是 app包下的Fragment 还是 V4包下的 Fragment)
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        // 使用 TabLayout 和 ViewPager 相关联
        mTabLayout.setupWithViewPager(mViewPager);
        // TabLayout指示器添加文本
        mTabLayout.getTabAt(0).setText("人气排名");
        mTabLayout.getTabAt(1).setText("关注");
        mTabLayout.getTabAt(2).setText("命中排名");

    }

    @Override
    protected void initView() {
        super.initView();
    }


    @OnClick(R.id.btn_gendan)
    public void onViewClicked() {
        changeImage(true);
        initmPopupWindowView();
    }

    private void changeImage(boolean b) {

        if (b) {
            imgXiala.setImageResource(R.drawable.icon_shouqi);
        } else {
            imgXiala.setImageResource(R.drawable.icon_xiala);
        }
    }

    @OnClick({R.id.btn_my_foucs, R.id.btn_hongdan_lottery_list, R.id.btn_lianhong_lottery_list, R.id.btn_daihong_lottery_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_my_foucs:
            case R.id.btn_hongdan_lottery_list:
                Intent intent = new Intent(getActivity(), LotteryListActivity.class);
                intent.putExtra("type", LotteryType.HONGDAN.getIndex());
                startActivity(intent);
                break;
            case R.id.btn_lianhong_lottery_list:
                Intent intent2 = new Intent(getActivity(), LotteryListActivity.class);
                intent2.putExtra("type", LotteryType.LIANHONG.getIndex());
                startActivity(intent2);
                break;
            case R.id.btn_daihong_lottery_list:
                Intent intent3 = new Intent(getActivity(), LotteryListActivity.class);
                intent3.putExtra("type", LotteryType.DAIHONG.getIndex());
                startActivity(intent3);
                break;
        }
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

    public void initmPopupWindowView() {

        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_documentary_type, null, false);
        mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.showAsDropDown(viewToolbar);
        // 设置背景半透明
        backgroundAlpha(0.7f, getActivity());

        mPopupWindow.setOnDismissListener(new popupDismissListener());

        contentView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        RadioGroup radioGroup = contentView.findViewById(R.id.rg_type);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // dimss();
            }
        });
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha, Context context) {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0-1.0
        ((Activity) context).getWindow().setAttributes(lp);
    }

    class popupDismissListener implements PopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            backgroundAlpha(1f, getActivity());
            changeImage(false);
        }
    }

    public void dimss() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        dimss();
    }
}