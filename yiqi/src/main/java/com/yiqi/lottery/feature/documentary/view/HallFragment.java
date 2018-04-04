package com.yiqi.lottery.feature.documentary.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.widget.EmptyView;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.DocumentaryBo;
import com.yiqi.lottery.feature.documentary.view.adapter.DocumentaryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryDetailActivity;

public class HallFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private DocumentaryAdapter mAdapter;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_hall;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    private void initAdapter() {
        // mRefreshLayout.autoRefresh();
        mAdapter = new DocumentaryAdapter();
//        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.bindToRecyclerView(mRecyclerview);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<DocumentaryBo> documentaryBoList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            documentaryBoList.add(new DocumentaryBo("大神" + i));
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(getActivity(),LotteryDetailActivity.class));
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(getActivity(),PersonalInfoActivity.class));

    }
}
