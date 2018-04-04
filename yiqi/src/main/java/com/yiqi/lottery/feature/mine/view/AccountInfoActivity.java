package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

import static com.suozhang.framework.utils.AppUtil.fullScreen;

public class AccountInfoActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_account_info;
    }

    @Override
    protected void initInjector() {

    }
    @Override
    protected void initView() {
        initToolBar(mToolbar, "账户明细", true, true);
    }


    @Override
    protected void initData() {

    }
    @Override
    protected void initSystemParams() {
//        super.initSystemParams();
        fullScreen(this);
    }

}
