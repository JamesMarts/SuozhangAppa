/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.control.view;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.CombineModelBo;
import com.suozhang.rentaluser.feature.control.view.adapter.LightAdapter;
import com.suozhang.rentaluser.feature.control.view.adapter.MyPagerAdapter;
import com.suozhang.rentaluser.feature.control.view.adapter.MyPagerButtomAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class ControlFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.vp_top)
    ViewPager mVpTop;
    @BindView(R.id.tbl_title)
    TabLayout mTabLayout;
    @BindView(R.id.vp_buttom)
    ViewPager mVpButtom;

    @BindView(R.id.view_smart_no_data)
    RelativeLayout mViewSmartNoData;
    @BindView(R.id.view_smart_have_data)
    LinearLayout mViewSmartHaveData;

    RadioButton mBtModelRead;
    RadioButton mBtModelBright;
    RadioButton mBtModelRomantic;
    RadioButton mBtModelSleep;
    RecyclerView mRvLight;
    RelativeLayout mViewLightColorControl;
    ImageView mIvAirModel;
    ImageView mIvAirLevel;
    RelativeLayout mIvAirBg;
    ImageView mIvModelBright;
    LinearLayout mTvTvShowWelcome;
    RelativeLayout mIvTvBg;
    ImageView mIvModelRomantic;

    ImageView mIvModelRead;

    ImageView mIvModelSleep;

    private LayoutInflater mInflater;

    private View mHeadLight, mHeadTv, mHeadAC, mHeadWindow, mHeadModel;//页卡视图
    private List<View> mViewTop = null;//页卡视图集合
    private View mButtomLight, mButtomTv, mButtomAC, mButtomWindow, mButtomModel;//页卡视图
    private List<View> mViewButtom = null;//页卡视图集合
    private LightAdapter mLightAdapter = null;

    TextView mTvAcTemperatureTop;
    TextView mTvAcTemperatureButtom;
    private int airTemperature = 26;
    private boolean isAirOn = false;
    private boolean isTvOn = false;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_control;
    }

    @Override
    protected void initView() {
        super.initView();
//
        initWedigt();
        initLightAdapter();
    }

    @Override
    protected void initInjector() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
    }

    private void initWedigt() {
        mViewTop = new ArrayList<>();
        mViewButtom = new ArrayList<>();
        List<String> mTitleLists = new ArrayList<>();//页卡标题集合


        mInflater = LayoutInflater.from(getActivity());
        mHeadLight = mInflater.inflate(R.layout.control_head_light, null);
        mHeadAC = mInflater.inflate(R.layout.control_head_ac, null);
        mHeadTv = mInflater.inflate(R.layout.control_head_tv, null);
        mHeadWindow = mInflater.inflate(R.layout.control_head_window, null);
        mHeadModel = mInflater.inflate(R.layout.control_head_model, null);


        mButtomLight = mInflater.inflate(R.layout.control_main_light, null);
        mButtomTv = mInflater.inflate(R.layout.control_main_tv, null);
        mButtomAC = mInflater.inflate(R.layout.control_main_ac, null);
        mButtomWindow = mInflater.inflate(R.layout.control_main_window, null);
        mButtomModel = mInflater.inflate(R.layout.control_main_model, null);

        mRvLight = mButtomLight.findViewById(R.id.rv_light);
        mViewLightColorControl = mButtomLight.findViewById(R.id.view_light_color_control);
        mTvAcTemperatureTop = mHeadAC.findViewById(R.id.tv_ac_temperature_top);
        mTvAcTemperatureButtom = mButtomAC.findViewById(R.id.tv_ac_temperature_buttom);
        mIvAirBg = mHeadAC.findViewById(R.id.iv_air_bg);
        mIvAirLevel = mHeadAC.findViewById(R.id.iv_air_level);
        mIvAirModel = mHeadAC.findViewById(R.id.iv_air_model);

        mBtModelBright = mButtomModel.findViewById(R.id.bt_model_bright);
        mBtModelRead = mButtomModel.findViewById(R.id.bt_model_read);
        mBtModelRomantic = mButtomModel.findViewById(R.id.bt_model_romantic);
        mBtModelSleep = mButtomModel.findViewById(R.id.bt_model_sleep);

        mIvModelBright = mHeadModel.findViewById(R.id.iv_model_bright);
        mIvModelRomantic = mHeadModel.findViewById(R.id.iv_model_romantic);
        mIvModelRead = mHeadModel.findViewById(R.id.iv_model_read);
        mIvModelSleep = mHeadModel.findViewById(R.id.iv_model_sleep);


        mBtModelBright.setOnCheckedChangeListener(this);
        mBtModelRead.setOnCheckedChangeListener(this);
        mBtModelRomantic.setOnCheckedChangeListener(this);
        mBtModelSleep.setOnCheckedChangeListener(this);


        (mButtomAC.findViewById(R.id.bt_air_to_cold)).setOnClickListener(click);
        (mButtomAC.findViewById(R.id.bt_air_to_warm)).setOnClickListener(click);
        (mButtomAC.findViewById(R.id.bt_air_temperature_add)).setOnClickListener(click);
        (mButtomAC.findViewById(R.id.bt_air_temperature_minus)).setOnClickListener(click);

        CheckBox cbxAc = mHeadAC.findViewById(R.id.cb_air_toggle);
        CheckBox cbxTv = mHeadTv.findViewById(R.id.cb_tv_toggle);
        cbxAc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                isAirOn = isChecked;
                initAir(isAirOn);
            }
        });
        cbxTv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                isTvOn = isChecked;
                tvControl(isTvOn);
            }
        });
        mTvTvShowWelcome = mHeadTv.findViewById(R.id.tv_tv_show_welcome);
        mIvTvBg = mHeadTv.findViewById(R.id.iv_tv_bg);

        (mButtomTv.findViewById(R.id.bt_tv_volume_minus)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_channel_add)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_volume_add)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_channel_minus)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_to_home)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_to_channel_minus)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_to_channel_add)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_to_back)).setOnClickListener(clickTv);
        (mButtomTv.findViewById(R.id.bt_tv_menu_ok)).setOnClickListener(clickTv);


        (mButtomWindow.findViewById(R.id.bt_window_pause)).setOnClickListener(clickWindow);
        (mButtomWindow.findViewById(R.id.bt_window_close)).setOnClickListener(clickWindow);
        (mButtomWindow.findViewById(R.id.bt_window_open)).setOnClickListener(clickWindow);
        (mButtomWindow.findViewById(R.id.bt_curtain_open)).setOnClickListener(clickWindow);
        (mButtomWindow.findViewById(R.id.bt_curtain_pause)).setOnClickListener(clickWindow);
        (mButtomWindow.findViewById(R.id.bt_curtain_close)).setOnClickListener(clickWindow);

        mTitleLists.add("灯光");
        mViewTop.add(mHeadLight);
        mViewButtom.add(mButtomLight);
        mTabLayout.addTab(mTabLayout.newTab().setText("灯光"));

        mViewTop.add(mHeadAC);
        mViewButtom.add(mButtomAC);
        mTitleLists.add("空调");
        mTabLayout.addTab(mTabLayout.newTab().setText("空调"));


        mTitleLists.add("电视");
        mViewTop.add(mHeadTv);
        mViewButtom.add(mButtomTv);
        mTabLayout.addTab(mTabLayout.newTab().setText("电视"));


        mTitleLists.add("窗户");
        mViewTop.add(mHeadWindow);
        mViewButtom.add(mButtomWindow);
        mTabLayout.addTab(mTabLayout.newTab().setText("窗户"));
        mTabLayout.setTag("窗户");


        mTitleLists.add("情景模式");
        mViewTop.add(mHeadModel);
        mViewButtom.add(mButtomModel);
        mTabLayout.addTab(mTabLayout.newTab().setText("情景模式"));

        final MyPagerAdapter mTopAdapter = new MyPagerAdapter(mViewTop);
        mVpTop.setAdapter(mTopAdapter);//给ViewPager设置适配器
//
        MyPagerButtomAdapter mButtomAdapter = new MyPagerButtomAdapter(mViewButtom, mTitleLists);
        mVpButtom.setAdapter(mButtomAdapter);//给ViewPager设置适配器

        if (mTitleLists != null && mTitleLists.size() > 4) {
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }

        initAir(isAirOn);
        tvControl(isTvOn);
        mTabLayout.setupWithViewPager(mVpButtom);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mButtomAdapter);//给Tabs设置适配器

        mVpButtom.setOnPageChangeListener(onButtomPageChangeListener);
        mVpTop.setOnPageChangeListener(onTopPageChangeListener);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {

                    if (tab.getText().equals("空调")) {
                        initAir(isAirOn);
                    }
                    if (tab.getText().equals("电视")) {
                        tvControl(isTvOn);
                    }
                } catch (Exception e) {

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                try {

                } catch (Exception e) {

                }
            }
        });

    }


    ViewPager.OnPageChangeListener onTopPageChangeListener = new ViewPager.OnPageChangeListener() {

        //private int index = 0;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            int width = mVpButtom.getWidth();
//            //滑动外部Viewpager
//            mVpButtom.scrollTo((int) (width * position + width * positionOffset), 0);
        }

        @Override
        public void onPageSelected(int position) {
            //  index = position;
            mVpButtom.setCurrentItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    ViewPager.OnPageChangeListener onButtomPageChangeListener = new ViewPager.OnPageChangeListener() {
        // private int index = 0;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


//            int width = mVpTop.getWidth();
////            //滑动内部Viewpager
//            mVpTop.scrollTo((int) (width * position + width * positionOffset), 0);
        }

        @Override
        public void onPageSelected(int position) {
//            index = position;
            mVpTop.setCurrentItem(position);

        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    /**
     * 初始化灯控
     */
    private void initLightAdapter() {
        mRvLight.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mLightAdapter = new LightAdapter(onCheckedChangeListener);
        mLightAdapter.bindToRecyclerView(mRvLight);

    }

    /**
     * 灯光控制
     */
    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CombineModelBo item = (CombineModelBo) buttonView.getTag();
            if (item.getDeviceSubType() == 4) {

                mViewLightColorControl.setVisibility(View.VISIBLE);
                if (isChecked) {


                } else {

                    mViewLightColorControl.setVisibility(View.GONE);
                }

            } else {
                if (isChecked) {


                } else {

                }
                mViewLightColorControl.setVisibility(View.GONE);
            }

        }
    };

    /**
     * 空调设备
     */
    private void initAir(boolean isairon) {
        String fontPath = "fonts/my.ttf";

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

        mTvAcTemperatureTop.setTypeface(tf);
        mTvAcTemperatureButtom.setTypeface(tf);


        if (isairon) {
            mTvAcTemperatureTop.setVisibility(View.VISIBLE);
            mTvAcTemperatureButtom.setVisibility(View.VISIBLE);
            mTvAcTemperatureTop.setText(airTemperature + "");
            mTvAcTemperatureButtom.setText(airTemperature + "");
            mIvAirBg.setBackgroundResource(R.drawable.pic_kk_air_open);
            mIvAirLevel.setVisibility(View.VISIBLE);
            mIvAirModel.setVisibility(View.VISIBLE);


        } else {
            mTvAcTemperatureTop.setVisibility(View.GONE);
            mTvAcTemperatureButtom.setVisibility(View.GONE);
            mIvAirBg.setBackgroundResource(R.drawable.pic_kk_air_close);
            mIvAirLevel.setVisibility(View.GONE);
            mIvAirModel.setVisibility(View.GONE);

        }


    }

    private void tvControl(boolean isOpen) {


        if (isOpen) {

            mIvTvBg.setBackgroundResource(R.drawable.pic_tv_on);
            mTvTvShowWelcome.setVisibility(View.VISIBLE);
        } else {

            mIvTvBg.setBackgroundResource(R.drawable.pic_tv_off);
            mTvTvShowWelcome.setVisibility(View.GONE);
        }
    }

    private void initModel(int model) {


        switch (model) {
            case 1:
                mIvModelBright.setVisibility(View.VISIBLE);
                mIvModelRomantic.setVisibility(View.GONE);
                mIvModelSleep.setVisibility(View.GONE);
                mIvModelRead.setVisibility(View.GONE);

                mBtModelBright.setChecked(true);
                mBtModelRead.setChecked(false);
                mBtModelRomantic.setChecked(false);
                mBtModelSleep.setChecked(false);

                break;
            case 2:
                mIvModelBright.setVisibility(View.GONE);
                mIvModelRomantic.setVisibility(View.VISIBLE);
                mIvModelSleep.setVisibility(View.GONE);
                mIvModelRead.setVisibility(View.GONE);

                mBtModelBright.setChecked(false);
                mBtModelRead.setChecked(false);
                mBtModelRomantic.setChecked(true);
                mBtModelSleep.setChecked(false);

                break;
            case 3:
                mIvModelBright.setVisibility(View.GONE);
                mIvModelRomantic.setVisibility(View.GONE);
                mIvModelSleep.setVisibility(View.VISIBLE);
                mIvModelRead.setVisibility(View.GONE);

                mBtModelBright.setChecked(false);
                mBtModelRead.setChecked(false);
                mBtModelRomantic.setChecked(false);
                mBtModelSleep.setChecked(true);

                break;
            case 4:
                mIvModelBright.setVisibility(View.GONE);
                mIvModelRomantic.setVisibility(View.GONE);
                mIvModelSleep.setVisibility(View.GONE);
                mIvModelRead.setVisibility(View.VISIBLE);

                mBtModelBright.setChecked(false);
                mBtModelRead.setChecked(true);
                mBtModelRomantic.setChecked(false);
                mBtModelSleep.setChecked(false);

                break;
        }
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch (view.getId()) {
                case R.id.bt_air_to_cold:
                    mIvAirModel.setImageResource(R.drawable.ic_kk_snow);

                    break;
                case R.id.bt_air_temperature_add:
                    if (airTemperature == 32) {
                        return;
                    }
                    airTemperature++;

                    break;
                case R.id.bt_air_to_warm:
                    mIvAirModel.setImageResource(R.drawable.ic_kk_sun);

                    break;
                case R.id.bt_air_temperature_minus:
                    if (airTemperature == 16) {
                        return;
                    }
                    airTemperature--;


                    break;
            }

            mTvAcTemperatureButtom.setText("" + airTemperature);
            mTvAcTemperatureTop.setText("" + airTemperature);
        }
    };
    View.OnClickListener clickTv = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.bt_tv_menu_ok:
                    break;
                case R.id.bt_tv_volume_minus:

                    break;
                case R.id.bt_tv_channel_add:

                    break;
                case R.id.bt_tv_volume_add:

                    break;
                case R.id.bt_tv_channel_minus:

                    break;
                case R.id.bt_tv_to_home:
                    break;
                case R.id.bt_tv_to_channel_minus:

                    break;
                case R.id.bt_tv_to_channel_add:

                    break;
                case R.id.bt_tv_to_back:
                    break;
            }
        }
    };

    View.OnClickListener clickWindow = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch (view.getId()) {
                case R.id.bt_window_pause:

                    break;
                case R.id.bt_window_close:

                    break;
                case R.id.bt_window_open:
                    break;
                case R.id.bt_curtain_open:
                    break;

                case R.id.bt_curtain_pause:

                    break;
                case R.id.bt_curtain_close:

                    break;
            }
        }
    };

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.bt_model_read:
                if (isChecked) {
                    initModel(4);
                }

                break;
            case R.id.bt_model_bright:
                if (isChecked) {
                    initModel(1);
                }

                break;
            case R.id.bt_model_romantic:
                if (isChecked) {
                    initModel(2);
                }
                break;
            case R.id.bt_model_sleep:
                if (isChecked) {
                    initModel(3);
                }
                break;
        }
    }
}
