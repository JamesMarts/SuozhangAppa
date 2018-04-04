package com.suozhang.rentaluser.feature.user.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.DaggerMessageComponent;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.MessagePresenterModule;
import com.suozhang.rentaluser.feature.user.view.adapter.MessageAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MessageActivity extends BaseActivity implements OnRefreshListener,
        MessageContract.View, BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Inject
    MessageContract.Presenter mPresenter;

    EmptyView mEmptyView;
    private MessageAdapter mAdapter;

    private List<MessageBo> mData=null;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_message;
    }

    @Override
    protected void initInjector() {
        DaggerMessageComponent.builder().messagePresenterModule(new MessagePresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "我的消息", true, true);

        initAdapter();
    }

    @Override
    protected void initData() {
        mPresenter.getMessageTypeList();
    }

    @Override
    protected void initEvent() {
        mRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();

    }


    @Override
    public void showSuccess(List<MessageBo> houseRoomBos) {
        mRefreshLayout.finishRefresh();
        mData=houseRoomBos;
        mAdapter.setNewData(mData);
    }

    @Override
    public void showMessageViewSuccess(MessageBo houseRoomBo) {

    }

    @Override
    public void showErrorMsg(String msg) {
        mRefreshLayout.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getErrorView(msg));
        mAdapter.setNewData(null);
    }

    @Override
    public void showEmpty() {
        mRefreshLayout.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无消息！"));
        mAdapter.setNewData(null);
    }

    @Override
    public void showMessageInfoSuccess(List<MessageBo> houseRoomBos) {

    }


    private void initAdapter() {
       // mRefreshLayout.autoRefresh();
        mAdapter = new MessageAdapter();
        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mAdapter.bindToRecyclerView(mRecyclerview);
        mAdapter.setEmptyView(mEmptyView.getEmptyView());
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=new Intent(this,MessageInfoActivity.class);
        intent.putExtra("msgId",mData.get(position).getType());
        intent.putExtra("title",mData.get(position).getName());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }
}
