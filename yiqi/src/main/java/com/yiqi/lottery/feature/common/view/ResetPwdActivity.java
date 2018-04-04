package com.yiqi.lottery.feature.common.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class ResetPwdActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_user_login)
    Button mBtnUserLogin;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_reset_pwd;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "重置密码", true, true);
    }
}
