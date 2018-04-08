package com.yiqi.lottery.feature.find.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class LotteryResultsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_lottery_results;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "开奖结果", true, true);
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_result_view)
    public void onViewClicked() {
        startActivity(new Intent(this,ResultViewActivity.class));
    }
}
