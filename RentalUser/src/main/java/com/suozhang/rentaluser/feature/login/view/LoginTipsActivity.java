/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.view;

import android.content.Intent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/6/5 16:59
 */

public class LoginTipsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.edt_name)
    TextView mEdtName;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;

    @BindView(R.id.cb_not_tips)
    CheckBox mNotTips;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login_tips;
    }

    @Override
    protected boolean isAddStack() {
        return false;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onBackPressed() {
        //使返回键失效
       // super.onBackPressed();
    }

    @OnClick(R.id.btn_cancel)
    public void onMBtnCancelClicked() {
        setLoginTipsOnly(true);
        finish();

    }

    @Override
    protected void initSystemParams() {
        // super.initSystemParams();
        //不弹出输入法键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }


    @OnClick(R.id.btn_submit)
    public void onMBtnSubmitClicked() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.cb_not_tips)
    public void onViewClicked() {
        AM.setLoginTips(!mNotTips.isChecked());
    }
}
