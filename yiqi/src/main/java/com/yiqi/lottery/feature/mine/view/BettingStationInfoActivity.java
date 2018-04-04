package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class BettingStationInfoActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_betting_station;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "投注站基本信息", true, true);

    }

    @Override
    protected void initData() {

    }

}
