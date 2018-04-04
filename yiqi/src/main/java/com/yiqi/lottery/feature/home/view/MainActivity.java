package com.yiqi.lottery.feature.home.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.yiqi.lottery.R;
import com.yiqi.lottery.feature.documentary.view.DocumentaryFragment;
import com.yiqi.lottery.feature.find.view.FindFragment;
import com.yiqi.lottery.feature.lottery.view.LotteryFragment;
import com.yiqi.lottery.feature.mine.view.MineFragment;

import butterknife.BindView;

import static com.suozhang.framework.utils.AppUtil.fullScreen;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;
    private LotteryFragment mLotteryFragment;
    private DocumentaryFragment mDocumentaryFragment;
    private FindFragment mFindFragment;
    private MineFragment mMineFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mFindFragment = new FindFragment();
        mLotteryFragment = new LotteryFragment();
        mDocumentaryFragment = new DocumentaryFragment();
        mMineFragment = new MineFragment();
        addFragment(R.id.fl_container, mLotteryFragment);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
        mRadiogroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {

            case R.id.rb_home_lottery:
                replaceFragment(R.id.fl_container, mLotteryFragment);
                break;
            case R.id.rb_home_documentary:
                replaceFragment(R.id.fl_container, mDocumentaryFragment);
                break;
            case R.id.rb_home_find:
                replaceFragment(R.id.fl_container, mFindFragment);
                break;
            case R.id.rb_home_mine:
                replaceFragment(R.id.fl_container, mMineFragment);
                break;
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //退出时的时间
    private long mExitTime;

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            T.showShort("再按一次退出常红彩站！");
            mExitTime = System.currentTimeMillis();
        } else {
            AM.appManager().exitApp();
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    protected void initSystemParams() {
//        super.initSystemParams();
        fullScreen(this);
    }




}
