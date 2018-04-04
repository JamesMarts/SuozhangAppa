package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.BeetingBo;
import com.yiqi.lottery.entity.bo.MessageBo;
import com.yiqi.lottery.feature.documentary.view.adapter.BeetingListAdapter;
import com.yiqi.lottery.feature.mine.view.adapter.MessageAdpter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener, BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_message)
    RecyclerView mRvMessage;
    MessageAdpter mAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_message;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {

        mToolbar.inflateMenu(R.menu.menu_user_nick_edit);
        mToolbar.setOnMenuItemClickListener(this);
        initToolBar(mToolbar, "消息中心", true, true);
    }

    @Override
    protected void initData() {
        initAdapter();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            T.showShort("item");
        }
        return false;
    }

    private void initAdapter() {

        mAdapter = new MessageAdpter();
//        mEmptyView = new EmptyView(mRecyclerview);
        mRvMessage.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.bindToRecyclerView(mRvMessage);
//        mAdapter.setEmptyView(mEmptyView.getEmptyView());

        List<MessageBo> documentaryBoList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            documentaryBoList.add(new MessageBo());
        }
        mAdapter.setNewData(documentaryBoList);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
