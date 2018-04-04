package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class EditPhoneActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.view_phone_first)
    LinearLayout mViewPhoneFirst;
    @BindView(R.id.view_phone_next)
    LinearLayout mViewPhoneNext;
    @BindView(R.id.view_phone_success)
    LinearLayout mViewPhoneSuccess;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_edit_phone;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "修改手机", true, true);
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btn_user_editphone_next, R.id.btn_user_editphone_comlete, R.id.btn_user_editphone_success})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_editphone_next:
                initToolBar(mToolbar, "验证新手机", true, true);
                mViewPhoneFirst.setVisibility(View.GONE);
                mViewPhoneNext.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_user_editphone_comlete:
                initToolBar(mToolbar, "修改手机", true, true);
                mViewPhoneFirst.setVisibility(View.GONE);
                mViewPhoneNext.setVisibility(View.GONE);
                mViewPhoneSuccess.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_user_editphone_success:
                finish();
                break;
        }
    }


}
