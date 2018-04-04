package com.suozhang.rentaluser.feature.user.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_FAQ)
    TextView mTvFAQ;
    @BindView(R.id.tv_feedback)
    TextView mTvFeedback;
    @BindView(R.id.tv_about)
    TextView mTvAbout;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_more;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_more, true, true);
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.tv_FAQ)
    public void onMTvFAQClicked() {
        T.showShort("功能暂未开放");
        // startToActivity(FAQActivity.class);
    }

    @OnClick(R.id.tv_feedback)
    public void onMTvFeedbackClicked() {
        startToActivity(FeedbackActivity.class);

    }

    @OnClick(R.id.tv_about)
    public void onMTvAboutClicked() {
        startToActivity(AboutActivity.class);
    }


    private void startToActivity(Class<? extends Activity> target) {
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}
