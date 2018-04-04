package com.suozhang.rentaluser.feature.home.view;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.control.view.ControlFragment;
import com.suozhang.rentaluser.feature.find.FindFragment;
import com.suozhang.rentaluser.feature.life.view.LifeFragment;
import com.suozhang.rentaluser.feature.rental.view.RentsFragment;
import com.suozhang.rentaluser.feature.user.view.UserFragment;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;



public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;

    private FindFragment mFindFragment;
    private UserFragment mUserFragment;
    private RentsFragment mRentsFragment;
    private LifeFragment mLifeFragment;
    private ControlFragment mControlFragment;

    private Handler handler = null;
    public static boolean isForeground = false;
    RxPermissions rxPermissions;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        rxPermissions = new RxPermissions(this);
        mFindFragment = new FindFragment();
        mUserFragment = new UserFragment();
        mRentsFragment = new RentsFragment();
        mLifeFragment = new LifeFragment();
        mControlFragment = new ControlFragment();
        addFragment(R.id.fl_container, mRentsFragment);
    }

    @Override
    protected void initData() {
        registerMessageReceiver();
        checkPrmiessionLocation();
    }

    @Override
    protected void initEvent() {
        mRadiogroup.setOnCheckedChangeListener(this);
    }


    private void checkPrmiessionLocation() {

        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {

                    } else {
                        // At least one permission is denied
                    }
                });

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {

            case R.id.rb_home_housing:
                replaceFragment(R.id.fl_container, mRentsFragment);
                break;
            case R.id.rb_home_order:
                replaceFragment(R.id.fl_container, mLifeFragment);
                break;
            case R.id.rb_home_msg:
                replaceFragment(R.id.fl_container, mControlFragment);
                break;
            case R.id.rb_home_my:
                replaceFragment(R.id.fl_container, mUserFragment);
                break;
        }
    }


    //发送消息给Fragment
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    //极光推送接收消息
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.suozhang.rentaluser.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append("收到的消息: " + messge + "\n");
                    if (!TextUtils.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }
                    T.showShort(showMsg.toString());
                }
            } catch (Exception e) {
                T.showShort(e.getMessage());
            }
        }
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
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
            T.showShort("再按一次退出锁掌公寓");
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
