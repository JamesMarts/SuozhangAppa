package com.yiqi.lottery.feature.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

import static com.suozhang.framework.utils.AppUtil.fullScreen;

public class WithdrawActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_withdraw;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "提现", true, true);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initSystemParams() {
//        super.initSystemParams();
        fullScreen(this);
    }


    @OnClick(R.id.btn_withdraw_wx)
    public void onViewClicked() {
        startActivity(new Intent(this, WithdrawAuthActivity.class));
    }
}
