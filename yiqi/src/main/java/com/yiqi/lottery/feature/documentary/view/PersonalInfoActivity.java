package com.yiqi.lottery.feature.documentary.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.AppUtil;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.LotteryBo;
import com.yiqi.lottery.entity.bo.PersonalLotteryBo;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryDaihongListAdapter;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryDetailActivity;
import com.yiqi.lottery.feature.documentary.view.adapter.PersonalLotteryAdapter;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfoActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_documentary_person_focus)
    TextView mTvDocumentaryPersonFocus;
    @BindView(R.id.iv_documentary_person_head)
    ImageView mIvDocumentaryPersonHead;
    @BindView(R.id.tv_documentary_person_name)
    TextView mTvDocumentaryPersonName;
    @BindView(R.id.rv_personal)
    RecyclerView mRvPersonal;
    private PersonalLotteryAdapter mLianhongAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initSystemParams() {
//        super.initSystemParams();
        AppUtil.fullScreen(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "个人信息", true, true);
    }

    @Override
    protected void initData() {
        initLianhongAdapter();
        AM.image().bindToCircleObject("http://himg2.huanqiu.com/attachment2010/2012/0517/20120517040321282.jpg", mIvDocumentaryPersonHead);
    }


    @OnClick(R.id.tv_documentary_person_focus)
    public void onViewClicked() {
    }


    private void initLianhongAdapter() {
        mLianhongAdapter = new PersonalLotteryAdapter();

//        mEmptyView = new EmptyView(mRecyclerview);
        mRvPersonal.setLayoutManager(new LinearLayoutManager(this));
        mRvPersonal.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(25));
        mLianhongAdapter.bindToRecyclerView(mRvPersonal);
//        mLianhongAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<PersonalLotteryBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            documentaryBoList.add(new PersonalLotteryBo());
        }
        mLianhongAdapter.setNewData(documentaryBoList);
        mLianhongAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(this, LotteryDetailActivity.class));
    }
}
