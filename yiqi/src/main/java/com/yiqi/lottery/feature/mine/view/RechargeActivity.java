package com.yiqi.lottery.feature.mine.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.framework.BaseActivity;
import com.yiqi.lottery.R;
import com.yiqi.lottery.feature.mine.view.adapter.RechargeMoneyAdapter;

import java.util.ArrayList;
import java.util.List;

public class RechargeActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_user_money)
    RecyclerView mRvUserMoney;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "充值", true, true);
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {
        initAdapter();
    }

    private void initAdapter() {
        mRvUserMoney.setLayoutManager(new GridLayoutManager(this, 3));
        List<Integer> mDateList = new ArrayList<>();
        mDateList.add(50);
        mDateList.add(100);
        mDateList.add(200);
        mDateList.add(500);
        mDateList.add(1000);
        mDateList.add(2000);
        RechargeMoneyAdapter mDateAdapter = new RechargeMoneyAdapter(mDateList);
        mRvUserMoney.setAdapter(mDateAdapter);
        mDateAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mDateAdapter.changeState(position);
            }
        });

    }

}