package com.yiqi.lottery.feature.mine.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class AboutActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    protected void initInjector() {

    }
    @Override
    protected void initView() {
        initToolBar(mToolbar, "关于", true, true);
    }
    @Override
    protected void initData() {

    }
}
