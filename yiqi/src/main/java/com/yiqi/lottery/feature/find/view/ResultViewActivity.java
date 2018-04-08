package com.yiqi.lottery.feature.find.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class ResultViewActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_more)
    ImageView mBtnMore;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_result_view;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mBtnMore.setVisibility(View.GONE);
        initToolBar(mToolbar, "大乐透", true, true);
    }

    @Override
    protected void initData() {

    }


}
