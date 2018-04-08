package com.yiqi.lottery.feature.common.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "用户注册", true, true);
    }

    @Override
    protected void initData() {

    }




    @OnClick({R.id.toolbar, R.id.btn_user_register_scan, R.id.btn_user_register, R.id.btn_user_register_had_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_user_register_scan:
                break;
            case R.id.btn_user_register:
                break;
            case R.id.btn_user_register_had_account:
                finish();
                break;
        }
    }
}