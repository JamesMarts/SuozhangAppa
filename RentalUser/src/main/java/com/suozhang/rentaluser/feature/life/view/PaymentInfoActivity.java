package com.suozhang.rentaluser.feature.life.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;

import java.util.List;

import butterknife.BindView;

public class PaymentInfoActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_view)
    RecyclerView mRvView;
    private InfoAdapter mAdapter;

    List<PaymentDetailBo.AppUserBillInfoBo> mData;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_payment_info;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar,"帐单详情",true,true);
    }

    @Override
    protected void initData() {
        initAdapter();
        mData=this.getIntent().getParcelableArrayListExtra("arrays");
        if (mData!=null){
            mAdapter.setNewData(mData);
        }

    }

    public  class InfoAdapter extends BaseQuickAdapter<PaymentDetailBo.AppUserBillInfoBo, BaseViewHolder> {

        public InfoAdapter() {
            super(R.layout.item_billing_detail);
        }

        @Override
        protected void convert(BaseViewHolder helper, PaymentDetailBo.AppUserBillInfoBo item) {
           helper.setText(R.id.tv_billing_detail_name,item.getCostName())
           .setText(R.id.tv_billing_detail_cost,item.getAmount()+"")
           ;
        }
    }

    private void initAdapter() {
        mRvView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new InfoAdapter();
        mAdapter.bindToRecyclerView(mRvView);
    }

}
