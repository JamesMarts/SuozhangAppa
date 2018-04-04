package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class EditPasswordActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_edit_password;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "修改密码", true, true);
    }


    @OnClick(R.id.btn_withdraw_wxs)
    public void onViewClicked() {
    }
}
