package com.yiqi.lottery.feature.find.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;

public class OrderShareCircleActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;

    private ShareCircleFragment mShareCircleFragment;
    private MineCircleFragment mMineCircleFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_order_share_circle;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "晒单圈", true, true);
    }

    @Override
    protected void initData() {
        mShareCircleFragment = new ShareCircleFragment();
        mMineCircleFragment = new MineCircleFragment();
        addFragment(R.id.fl_container, mShareCircleFragment);

    }

    @Override
    protected void initEvent() {
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rb_share_circle:
                        replaceFragment(R.id.fl_container, mShareCircleFragment);
                        break;
                    case R.id.rb_write_circle:
                     startActivity(new Intent(OrderShareCircleActivity.this,WriteCircleActivity.class));
                        break;
                    case R.id.rb_mine_circle:
                        replaceFragment(R.id.fl_container, mMineCircleFragment);
                        break;

                }
            }
        });
    }
}
