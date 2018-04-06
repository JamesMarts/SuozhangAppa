package com.yiqi.lottery.feature.find.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.BeetingBo;
import com.yiqi.lottery.entity.bo.CircleBo;
import com.yiqi.lottery.feature.find.view.adapter.CircleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderShareCircleActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener, Toolbar.OnMenuItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_find_circle)
    RecyclerView mRvFindCircle;
    private CircleAdapter mAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_order_share_circle;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mToolbar.inflateMenu(R.menu.menu_find_circle_add);
        initToolBar(mToolbar, "晒单圈", true, true);
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    protected void initData() {
        initAdapter();
    }

    private void initAdapter() {

        mAdapter = new CircleAdapter();
//        mEmptyView = new EmptyView(mRecyclerview);
        mRvFindCircle.setLayoutManager(new LinearLayoutManager(this));
        mRvFindCircle.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(25));
        mAdapter.bindToRecyclerView(mRvFindCircle);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<CircleBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            documentaryBoList.add(new CircleBo());
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChecked(new CircleAdapter.GetCheckedValue() {
            @Override
            public void getValue(String ids) {

            }
        });
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
               startActivity(new Intent(this,WriteCircleActivity.class));
                break;
        }
        return true;

    }
}
