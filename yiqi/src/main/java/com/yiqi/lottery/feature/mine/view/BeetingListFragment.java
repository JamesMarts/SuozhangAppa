package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
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
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseFragment;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.BeetingBo;
import com.yiqi.lottery.entity.bo.LotteryBo;
import com.yiqi.lottery.feature.documentary.view.adapter.BeetingListAdapter;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryListAdapter;

import java.util.ArrayList;
import java.util.List;


public class BeetingListFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    BeetingListAdapter mAdapter;
    @BindView(R.id.rv_lottery_list)
    RecyclerView mRvBeeting;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_beeting_list;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter();
    }

    @Override
    protected void initEvent() {

    }

    private void initAdapter() {

        mAdapter = new BeetingListAdapter();
//        mEmptyView = new EmptyView(mRecyclerview);
        mRvBeeting.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvBeeting.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(2));
        mAdapter.bindToRecyclerView(mRvBeeting);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<BeetingBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            documentaryBoList.add(new BeetingBo("201800" + i));
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
