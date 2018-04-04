package com.suozhang.rentaluser.feature.user.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/14 11:22
 */

public class AccountSafeActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_account_safe;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_account_safe);
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.tv_modify_phone)
    public void onMTvModifyPhoneClicked() {
        startToActivity(ModifyPhoneActivity.class);

    }

    @OnClick(R.id.tv_modify_login_pwd)
    public void onMTvModifyLoginPwdClicked() {
        startToActivity(ModifyPasswordActivity.class);
    }



    private void startToActivity(Class<? extends Activity> target) {
        startActivity(new Intent(this, target));
    }
}
