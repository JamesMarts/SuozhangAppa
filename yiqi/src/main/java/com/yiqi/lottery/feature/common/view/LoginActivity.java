package com.yiqi.lottery.feature.common.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "登录", true, true);
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btn_user_login, R.id.btn_user_forget, R.id.btn_user_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_login:
                break;
            case R.id.btn_user_forget:
                startActivity(new Intent(this,ResetPwdActivity.class));
                break;
            case R.id.btn_user_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
