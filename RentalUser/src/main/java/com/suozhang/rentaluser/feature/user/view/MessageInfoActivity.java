package com.suozhang.rentaluser.feature.user.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.feature.life.view.BillingDetailActivity;
import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.DaggerMessageComponent;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.MessagePresenterModule;
import com.suozhang.rentaluser.feature.user.view.adapter.MessageInfoAdapter;
import com.suozhang.rentaluser.feature.user.view.adapter.MessageViewActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MessageInfoActivity extends BaseActivity implements MessageContract.View, BaseQuickAdapter.OnItemClickListener, OnRefreshListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String mMsgId = "";
    private MessageInfoAdapter mAdapter;
    EmptyView mEmptyView;
    private List<MessageBo> mData;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_message_info;
    }

    @Override
    protected void initInjector() {
        DaggerMessageComponent.builder().messagePresenterModule(new MessagePresenterModule(this)).build().inject(this);
    }

    @Inject
    MessageContract.Presenter mPresenter;

    @Override
    protected void initView() {
        mMsgId = this.getIntent().getStringExtra("msgId");
        String title=this.getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(title)){
            initToolBar(mToolbar,title,true,true);
        }else {
            initToolBar(mToolbar,"通知",true,true);
        }
        initAdapter();
    }

    @Override
    protected void initData() {
        if (!TextUtils.isEmpty(mMsgId)) {
            mPresenter.doMessageInfoList(mMsgId);
        }
    }

    @Override
    protected void initEvent() {
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void showSuccess(List<MessageBo> houseRoomBos) {

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
        mRefreshLayout.finishRefresh();
        mData=houseRoomBos;
        mAdapter.setNewData(mData);
    }

    private void initAdapter() {
       // mRefreshLayout.autoRefresh();
        mAdapter = new MessageInfoAdapter();
        mEmptyView = new EmptyView(mRecyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mAdapter.bindToRecyclerView(mRecyclerview);
        mAdapter.setEmptyView(mEmptyView.getEmptyView());
        mAdapter.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        MessageBo messageBo=mData.get(position);
        if (messageBo!=null&&!TextUtils.isEmpty(messageBo.getBusinessId())){
            mPresenter.doUpdateMessageState(messageBo.getId());
            Intent intent=new Intent(this,BillingDetailActivity.class);
            intent.putExtra("id",mData.get(position).getBusinessId());
            startActivity(intent);
        }else {
            Intent intent=new Intent(this,MessageViewActivity.class);
            intent.putExtra("msgId",mData.get(position).getId());
            startActivity(intent);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }
}
