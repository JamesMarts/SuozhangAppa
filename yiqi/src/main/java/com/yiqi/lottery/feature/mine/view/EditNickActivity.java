package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditNickActivity extends BaseActivity  {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_edit_nick;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {

        initToolBar(mToolbar, "", true, true);
    }

    @Override
    protected void initData() {

    }



}
