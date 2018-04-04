package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;
import com.suozhang.rentaluser.feature.life.contract.PaymentContract;
import com.suozhang.rentaluser.feature.life.dependencies.payment.DaggerPaymentComponent;
import com.suozhang.rentaluser.feature.life.dependencies.payment.PaymentPresenterModule;
import com.suozhang.rentaluser.feature.life.view.adapter.PaymentRecordsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PaymentRecordsActivity extends BaseActivity implements PaymentContract.View, OnRefreshListener, BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_payment_records)
    RecyclerView mRvPaymentRecords;
    PaymentRecordsAdapter mAdapter;
    private EmptyView mEmptyView;
    @Inject
    PaymentContract.Presenter mPresenter;

    @BindView(R.id.ref)
    SmartRefreshLayout mRef;
    List<PaymentDetailBo> mData;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_payment_records;
    }

    @Override
    protected void initInjector() {
        DaggerPaymentComponent.builder().paymentPresenterModule(new PaymentPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "缴费记录", true, true);
        initAdapter();
    }

    @Override
    protected void initData() {
        mPresenter.getPayMentList();
    }

    @Override
    protected void initEvent() {
        mRef.setOnRefreshListener(this);

    }

    @Override
    public void showSuccess(List<PaymentDetailBo> billingDetailBo) {
        mRef.finishRefresh();
        mData = billingDetailBo;
        mAdapter.setNewData(mData);
    }

    @Override
    public void showErrorMsg(String msg) {
        mRef.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView(msg));
        mAdapter.setNewData(null);
    }

    @Override
    public void showEmpty() {
        mRef.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无缴费记录！"));
        mAdapter.setNewData(null);
    }

    private void initAdapter() {
        mRvPaymentRecords.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PaymentRecordsAdapter();
        mEmptyView = new EmptyView(mRvPaymentRecords);
        mRvPaymentRecords.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mAdapter.loadMoreEnd();
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(this, PaymentInfoActivity.class);
        intent.putParcelableArrayListExtra("arrays", (ArrayList<? extends Parcelable>) mData.get(position).getAppUserBillInfo());
        startActivity(intent);
    }
}
