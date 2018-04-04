package com.suozhang.rentaluser.feature.user.view;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.decoration.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.feature.rental.view.HouseActivity;
import com.suozhang.rentaluser.feature.rental.view.adapter.RentalAdapter;
import com.suozhang.rentaluser.feature.user.contract.CollectionContract;
import com.suozhang.rentaluser.feature.user.dependencies.collection.CollectionPresenterModule;
import com.suozhang.rentaluser.feature.user.dependencies.collection.DaggerCollectionComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends BaseFragment implements CollectionContract.View, BaseQuickAdapter.OnItemClickListener, OnRefreshListener {


    @Inject

    CollectionContract.Presenter mPresenter;
    @BindView(R.id.rc_my_contract)
    RecyclerView mRcMyContract;
    Unbinder unbinder;
    @BindView(R.id.smartRefesh)
    SmartRefreshLayout mSmartRefesh;

    private RentalAdapter mAdapter;
    private EmptyView mEmptyView;
    private List<HouseRoomBo> mHouseData;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void initInjector() {
        DaggerCollectionComponent.builder().collectionPresenterModule(new CollectionPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initAdapter();
    }

    @Override
    protected void initData() {
        mPresenter.getCollectionList();
    }

    @Override
    protected void initEvent() {
        mSmartRefesh.setOnRefreshListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Override
    public void showSuccess(List<HouseRoomBo> houseRoomBos) {
        mSmartRefesh.finishRefresh();
        mHouseData = houseRoomBos;
        mAdapter.setNewData(mHouseData);
        mSmartRefesh.finishLoadMoreWithNoMoreData();
    }

    @Override
    public void showErrorMsg(String msg) {
        mSmartRefesh.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView(msg));
        mAdapter.setNewData(null);
    }

    @Override
    public void showEmpty() {
        mSmartRefesh.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无收藏信息!"));
        mAdapter.setNewData(null);
    }

    private void initAdapter() {
        mAdapter = new RentalAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRcMyContract.setLayoutManager(linearLayoutManager);
        mRcMyContract.addItemDecoration(new RecycleViewDivider(
                getActivity(), LinearLayoutManager.VERTICAL, 40, getResources().getColor(R.color.window_background)));
        mAdapter.bindToRecyclerView(mRcMyContract);
        mEmptyView = new EmptyView(mRcMyContract);
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(getActivity(), HouseActivity.class);
        intent.putExtra("id", mHouseData.get(position).getId());
        startActivity(intent);
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }
}