package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.life.view.adapter.MyRepairAdapter;
import com.suozhang.rentaluser.framework.DataServer;

import butterknife.BindView;

public class RepairServiceActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_repair_services)
    RecyclerView mRvRepairServices;

    MyRepairAdapter myRepairAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_warranty_service;
    }

    @Override
    protected void initInjector() {

    }

    protected void initView() {
        initToolBar(mToolbar, "报修服务", true, true);
    }

    @Override
    protected void initData() {
        initAdapter();
    }

    private void initAdapter() {
        myRepairAdapter = new MyRepairAdapter();
        mRvRepairServices.setLayoutManager(new LinearLayoutManager(this));
        myRepairAdapter.setNewData(DataServer.getRepairList());
        mRvRepairServices.setAdapter(myRepairAdapter);
        myRepairAdapter.setOnItemClickListener(this);
        myRepairAdapter.loadMoreEnd();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(this, RepairInfoActivity.class);
        startActivity(intent);
    }
}
