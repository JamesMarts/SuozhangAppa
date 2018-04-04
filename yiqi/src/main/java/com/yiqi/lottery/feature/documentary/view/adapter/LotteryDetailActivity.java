package com.yiqi.lottery.feature.documentary.view.adapter;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class LotteryDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_lottery_detail;
    }

    @Override
    protected void initInjector() {

    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "跟单详情", true, true);
    }
}
