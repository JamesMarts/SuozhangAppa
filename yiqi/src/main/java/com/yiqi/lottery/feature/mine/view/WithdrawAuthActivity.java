package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class WithdrawAuthActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_withdraw_auth;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "提现账户认证", true, true);
    }

    @Override
    protected void initData() {

    }


}
