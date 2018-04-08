package com.yiqi.lottery.feature.find.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.suozhang.framework.framework.BaseFragment;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.DocumentaryBo;
import com.yiqi.lottery.entity.bo.FindScoreBo;
import com.yiqi.lottery.feature.documentary.view.adapter.DocumentaryAdapter;
import com.yiqi.lottery.feature.find.view.adapter.FindScoreAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindScoreListFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.rv_lottery_list)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;
    private FindScoreAdapter mAdapter;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_find_score_list;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {
        initAdapter();
    }

    @Override
    protected void initEvent() {

    }
    private void initAdapter() {
        // mRefreshLayout.autoRefresh();
        mAdapter = new FindScoreAdapter();
//        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerview.addItemDecoration(new com.suozhang.framework.component.recyclerview.DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(25));
        mAdapter.bindToRecyclerView(mRecyclerview);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<FindScoreBo> documentaryBoList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            documentaryBoList.add(new FindScoreBo(0));
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
