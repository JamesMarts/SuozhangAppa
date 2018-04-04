package com.suozhang.rentaluser.feature.rental.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.feature.rental.contract.ReportContract;
import com.suozhang.rentaluser.feature.rental.dependencies.report.DaggerReportComponent;
import com.suozhang.rentaluser.feature.rental.dependencies.report.ReportPresenterModule;
import com.suozhang.rentaluser.feature.rental.view.adapter.ReportReasonAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Li
 */
public class ReportRentActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener, ReportContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_report_reason)
    RecyclerView mRvReportReason;

    @Inject
    ReportContract.Presenter mPresenter;
    @BindView(R.id.edt_report_description)
    PowerfulEditText mEdtReportDescription;
    private ReportReasonAdapter mAdapter;
    private String mHouseId = "";
    private String mReportId = "";
    List<BaseBo> mData = null;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_report_rent;
    }

    @Override
    protected void initInjector() {
        DaggerReportComponent.builder().reportPresenterModule(new ReportPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "举报房源", true, true);

    }

    @Override
    protected void initData() {
        mHouseId = this.getIntent().getStringExtra("id");
        mPresenter.doGetReportType();
    }

    private void initAdapter(List<BaseBo> baseBos) {
        mAdapter = new ReportReasonAdapter(baseBos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvReportReason.setLayoutManager(linearLayoutManager);
        mRvReportReason.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mRvReportReason.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        mAdapter.changeState(position);
        mReportId = mData.get(position).getId();
    }


    @Override
    public void showSuccess(List<BaseBo> baseBos) {
        mData = baseBos;
        initAdapter(mData);
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showReportSuccess(String msg) {
        finish();
        T.showShort("举报成功！");

    }

    @Override
    public void showReportErrorMsg(String msg) {
        T.showShort(msg);
    }


    @OnClick(R.id.bt_commit)
    public void onViewClicked() {
        mPresenter.doReportHouse(mReportId, mHouseId, mEdtReportDescription.getText().toString());
    }

}
