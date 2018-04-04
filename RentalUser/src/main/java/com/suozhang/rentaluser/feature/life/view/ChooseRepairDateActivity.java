package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.feature.life.view.adapter.RepairDateAdapter;
import com.suozhang.rentaluser.feature.life.view.adapter.RepairTimeAdapter;
import com.suozhang.rentaluser.framework.DataServer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooseRepairDateActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_repair_reason)
    RecyclerView mRvRepairReason;
    RepairDateAdapter mDateAdapter;
    RepairTimeAdapter mTimeAdapter;
    @BindView(R.id.rv_repair_time)
    RecyclerView mRvRepairTime;
    private List<String> mDateList = new ArrayList<>();
    private List<BaseBo> mTimeList = new ArrayList<>();
    private String mDate = "";
    private String mTime = "";


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_choose_repair_date;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mToolbar.inflateMenu(R.menu.menu_contact_commit);
        initToolBar(mToolbar, "选择上门时间", true, true);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (TextUtils.isEmpty(mDate)) {
                    T.showShort("请选择预约日期！");
                    return false;
                }
                if (TextUtils.isEmpty(mTime)) {
                    T.showShort("请选择预约时间！");
                    return false;
                }
                Intent mIntent = new Intent();
                mIntent.putExtra("date", mDate);
                mIntent.putExtra("time", mTime);
                // 设置结果，并进行传送
                ChooseRepairDateActivity.this.setResult(0, mIntent);
                finish();
                return false;
            }
        });
    }

    @Override
    protected void initData() {
        mDateList = DateUtil.test(7);
        mTimeList = DataServer.getDateData();
        initDateAdapter();
        initTimeAdapter();
    }

    private void initDateAdapter() {
        mRvRepairReason.setLayoutManager(new GridLayoutManager(this, 4));
        mDateAdapter = new RepairDateAdapter(mDateList);
        mRvRepairReason.setAdapter(mDateAdapter);
        mDateAdapter.setOnItemClickListener(this);
    }

    private void initTimeAdapter() {
        mRvRepairTime.setLayoutManager(new LinearLayoutManager(this));
        mRvRepairTime.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mTimeAdapter = new RepairTimeAdapter(mTimeList);
        mRvRepairTime.setAdapter(mTimeAdapter);
        mTimeAdapter.setOnItemClickListener(listener);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        mDateAdapter.changeState(position);
        mDate = mDateList.get(position);
    }

    private BaseQuickAdapter.OnItemClickListener listener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            mTimeAdapter.changeState(position);
            mTime = mTimeList.get(position).getName();
        }
    };

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        if (item.getItemId() == R.menu.menu_contact_commit) {
//            T.showShort("commit");
//
//        }
//        return false;
//    }
}
