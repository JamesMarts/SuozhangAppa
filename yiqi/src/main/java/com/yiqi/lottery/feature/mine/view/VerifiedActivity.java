package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.yiqi.lottery.R;

public class VerifiedActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_verified;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mToolbar.inflateMenu(R.menu.menu_user_contact_service);
        mToolbar.setOnMenuItemClickListener(this);
        initToolBar(mToolbar, "实名认证", true, true);
    }

    @Override
    protected void initData() {

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            T.showShort("联系客服");
        }
        return false;
    }
}
