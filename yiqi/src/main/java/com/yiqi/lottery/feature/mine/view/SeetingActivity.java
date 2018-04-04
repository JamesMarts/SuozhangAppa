package com.yiqi.lottery.feature.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;


public class SeetingActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_seeting;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "设置", true, true);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_user_setting_version, R.id.btn_user_setting_about, R.id.btn_user_setting_clear, R.id.btn_user_setting_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_setting_version:
                break;
            case R.id.btn_user_setting_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;
            case R.id.btn_user_setting_clear:
                break;
            case R.id.btn_user_setting_quit:
                break;
        }
    }
}
