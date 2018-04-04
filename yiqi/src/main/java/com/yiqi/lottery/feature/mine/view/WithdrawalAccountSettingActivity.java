package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class WithdrawalAccountSettingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_withdraw_wxs)
    Button mBtnWithdrawWxs;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_withdrawal_account_setting;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "提现账户设置", true, true);
    }

    @Override
    protected void initData() {

    }


}
