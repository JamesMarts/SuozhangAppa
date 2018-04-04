package com.yiqi.lottery.feature.documentary.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.LotteryBo;
import com.yiqi.lottery.entity.enums.LotteryType;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryDaihongListAdapter;
import com.yiqi.lottery.feature.documentary.view.adapter.LotteryListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LotteryListActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_lottery_list)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private LotteryListAdapter mAdapter;
    private LotteryDaihongListAdapter mLianhongAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_lottery_list;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();
        Integer pos = this.getIntent().getIntExtra("type", 0);
        initToolBar(toolbar, LotteryType.getName(pos), true, true);
        if (pos==LotteryType.DAIHONG.getIndex()){
            initLianhongAdapter();
        }else {
            initAdapter(pos);
        }
    }

    @Override
    protected void initData() {

    }

    private void initAdapter(int type) {

        mAdapter = new LotteryListAdapter(type);
//        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(25));
        mAdapter.bindToRecyclerView(mRecyclerview);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<LotteryBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            documentaryBoList.add(new LotteryBo("" + i));
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
    }

    private void initLianhongAdapter() {
        mLianhongAdapter = new LotteryDaihongListAdapter();

//        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL).setHeight(25));
        mLianhongAdapter.bindToRecyclerView(mRecyclerview);
//        mLianhongAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<LotteryBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            documentaryBoList.add(new LotteryBo("" + i));
        }
        mLianhongAdapter.setNewData(documentaryBoList);
        mLianhongAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
