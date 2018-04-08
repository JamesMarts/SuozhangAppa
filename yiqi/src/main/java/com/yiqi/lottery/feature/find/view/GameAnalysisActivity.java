package com.yiqi.lottery.feature.find.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.enums.LotteryType;

public class GameAnalysisActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_game_analysis;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "比赛分析", true, true);
    }
}
