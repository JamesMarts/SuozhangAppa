package com.suozhang.rentaluser.feature.life.view;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.ContractBo;
import com.suozhang.rentaluser.feature.life.contract.ContractContract;
import com.suozhang.rentaluser.feature.life.dependencies.contract.ContractPresenterModule;
import com.suozhang.rentaluser.feature.life.dependencies.contract.DaggerContractComponent;
import com.suozhang.rentaluser.feature.life.view.adapter.MyContractSAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContractingFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener, ContractContract.View, OnRefreshListener {


    @BindView(R.id.rc_my_contract)
    RecyclerView mRcMyContract;
    MyContractSAdapter mAdapter;
    @BindView(R.id.srfl)
    SmartRefreshLayout mSrfl;
    private EmptyView mEmptyView;

    public boolean isCurrentContract = true;

    private List<ContractBo> mData = null;

    @Inject
    ContractContract.Presenter mPresenter;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_contracting;
    }

    @Override
    protected void initInjector() {
        DaggerContractComponent.builder().contractPresenterModule(new ContractPresenterModule(this)).build().inject(this);
    }


    @Override
    protected void initView() {
        initAdapter();
    }

    @Override
    protected void initData() {

        mPresenter.getContractList(isCurrentContract);

    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getContractList(isCurrentContract);
    }

    @Override
    protected void initEvent() {
        mSrfl.setOnRefreshListener(this);

    }

    private void initAdapter() {
        mAdapter = new MyContractSAdapter();
        mRcMyContract.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRcMyContract.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mAdapter.bindToRecyclerView(mRcMyContract);
        mEmptyView = new EmptyView(mRcMyContract);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(getActivity(), ContractInfoActivity.class);
        intent.putExtra("id", mData.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void showSuccess(List<ContractBo> contractBos) {
        mSrfl.finishRefresh();
        mData = contractBos;
        mAdapter.setNewData(mData);
    }

    @Override
    public void showErrorMsg(String msg) {
        mSrfl.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getErrorView(msg));
        mAdapter.setNewData(null);
    }

    @Override
    public void showEmpty() {
        mSrfl.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无合同数据！"));
        mAdapter.setNewData(null);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }




}
