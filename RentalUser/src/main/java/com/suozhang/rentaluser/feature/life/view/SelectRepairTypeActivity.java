package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.life.view.adapter.RepairReasonAdapter;
import com.suozhang.rentaluser.framework.DataServer;

import butterknife.BindView;

public class SelectRepairTypeActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_repair_reason)
    RecyclerView mRvRepairReason;

    RepairReasonAdapter mAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_select_repair_type;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "选择报修类型", true, true);
    }

    @Override
    protected void initData() {
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new RepairReasonAdapter(DataServer.getConfigImage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvRepairReason.setLayoutManager(linearLayoutManager);
        mRvRepairReason.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mRvRepairReason.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        mAdapter.changeState(position);
        Intent mIntent = new Intent();
        mIntent.putExtra("type", DataServer.getConfigImage().get(position).getName());
        // 设置结果，并进行传送
        this.setResult(0, mIntent);
        finish();
    }
}
