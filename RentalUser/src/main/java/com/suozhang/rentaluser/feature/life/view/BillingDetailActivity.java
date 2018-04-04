package com.suozhang.rentaluser.feature.life.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.MD5Util;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.alipay.AlipayUtils;
import com.suozhang.rentaluser.common.alipay.PayResult;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyRes;
import com.suozhang.rentaluser.entity.bo.WXPayBo;
import com.suozhang.rentaluser.entity.enums.PayType;
import com.suozhang.rentaluser.feature.life.contract.BillContract;
import com.suozhang.rentaluser.feature.life.dependencies.bill.BillPresenterModule;
import com.suozhang.rentaluser.feature.life.dependencies.bill.DaggerBillComponent;
import com.suozhang.rentaluser.feature.life.view.adapter.LifeBillsDetailAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Li
 */
public class BillingDetailActivity extends BaseActivity implements BillContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_billing_details)
    RecyclerView mRvBillingDetails;
    LifeBillsDetailAdapter mAdapter;

    @Inject
    BillContract.Presenter mPresenter;
    @BindView(R.id.tv_bill_people_name)
    TextView mTvBillPeopleName;
    @BindView(R.id.tv_bill_room_name)
    TextView mTvBillRoomName;
    @BindView(R.id.tv_bill_room_date)
    TextView mTvBillRoomDate;
    @BindView(R.id.tv_bill_pay_amount)
    TextView mTvBillPayAmount;
    @BindView(R.id.edt_refused_reason)
    EditText mEdtRefusedReason;
    @BindView(R.id.view_refused_reason)
    LinearLayout mViewRefusedReason;
    @BindView(R.id.view_buttom)
    LinearLayout mViewButtom;
    @BindView(R.id.btn_refused_reason)
    TextView mBtnRefusedReason;
    @BindView(R.id.view_dd)
    LinearLayout mViewDd;


    private String mBillId;
    public static final int MSG_PAY_FLAG = 4;
    public static final int MSG_CHECK_FLAG = 5;
    private int mPayType = PayType.AliPay.value();
    PayDialog payDialog = null;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_billing_detail;
    }

    @Override
    protected void initInjector() {
        DaggerBillComponent.builder().billPresenterModule(new BillPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "账单详情", true, true);
    }

    @Override
    protected void initData() {
        mBillId = this.getIntent().getStringExtra("id");
        if (!TextUtils.isEmpty(mBillId)) {
            mPresenter.getMyBillInfo(mBillId);
        }

    }


    private void initAdapter(MyLifeBo contractBos) {
        if (contractBos == null) {
            return;
        }
        mTvBillPeopleName.setText(TextUtils.isEmpty(contractBos.getCheckInfoPepoleName()) ? "" : contractBos.getCheckInfoPepoleName());
        mTvBillRoomName.setText(TextUtils.isEmpty(contractBos.getRoomName()) ? "" : contractBos.getRoomName());
        if (contractBos.getBillStartDate() != null && contractBos.getBillEndDate() != null) {
            mTvBillRoomDate.setText(DateUtil.getTimeStr(contractBos.getBillStartDate()) + "-" + DateUtil.getTimeStr(contractBos.getBillEndDate()));
        }
        mTvBillPayAmount.setText(contractBos.getPayAmount() + "");
        mRvBillingDetails.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new LifeBillsDetailAdapter(contractBos.getAppUserBillInfo());
        mRvBillingDetails.setAdapter(mAdapter);

        if (contractBos.getBillStatus() == 0) {
            mViewDd.setVisibility(View.GONE);
        } else {
            mViewDd.setVisibility(View.VISIBLE);
        }

    }


    @OnClick({R.id.btn_to_call_phone, R.id.btn_to_doubt, R.id.btn_to_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_to_call_phone:
                break;
            case R.id.btn_to_doubt:
                mViewButtom.setVisibility(View.GONE);
                mBtnRefusedReason.setVisibility(View.VISIBLE);
                mViewRefusedReason.setVisibility(View.VISIBLE);

                break;
            case R.id.btn_to_pay:
                payDialog = new PayDialog(this);
                payDialog.show();
                payDialog.setListener(new PayDialog.MyClickListenerInterface() {
                    @Override
                    public void doConfirm(int type) {
                        mPresenter.getAlipayInfo(mBillId);
                    }
                });
                break;
        }
    }

    @Override
    public void showSuccess(MyLifeBo contractBos) {
        initAdapter(contractBos);
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showRefauseSuccess(String contractBos) {
        T.showShort("拒绝成功！");
        finish();
    }

    @Override
    public void showRefauseError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showWxPayResult(WXPayBo msg) {

    }

    @Override
    public void showAlipayResult(AlipayBo msg) {
        toAlipay(msg);
    }

    @Override
    public void showNotitySuccess(PayNotifyRes msg) {
        T.showShort("支付成功！");
    }

    @Override
    public void showNotityError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showPayErrorMsg(String msg) {
        T.showShort(msg);
    }

    /**
     * 支付宝支付
     */

    private void toAlipay(AlipayBo bo) {
        if (mBillId != null) {
            AlipayUtils utils = new AlipayUtils(this, mHander, mBillId);
            utils.pay(bo);
        }


    }

    Handler mHander = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_CHECK_FLAG:

                    break;
                case MSG_PAY_FLAG:
                    getAlipayResult(msg.obj.toString());
                    break;
            }

            return false;
        }
    });


    /**
     * 获取支付宝支付结果
     */
    private void getAlipayResult(String msg) {

        PayResult payResult = new PayResult(msg);

        String resultStatus = payResult.getResultStatus();
        if (TextUtils.equals(resultStatus, "9000")) {
            if (!TextUtils.isEmpty(mBillId)) {
                sendPayResult(mBillId);
            }
            if (payDialog != null && payDialog.isShowing()) {
                payDialog.dismiss();
            }
            finish();

        } else if (TextUtils.equals(resultStatus, "4000")) {
            T.showShort("订单支付失败");
        } else if (TextUtils.equals(resultStatus, "8000")) {
            T.showShort("支付结果确认中");
        } else if (TextUtils.equals(resultStatus, "6001")) {
            T.showShort("取消支付");
        } else if (TextUtils.equals(resultStatus, "6002")) {
            T.showShort("网络连接出错");
        } else if (TextUtils.equals(resultStatus, "6004")) {
            T.showShort("支付结果未知");
        } else if (TextUtils.equals(resultStatus, "5000")) {
            T.showShort("重复请求");
        } else {
            T.showShort("其它支付错误");
        }

    }

    private void sendPayResult(String id) {
        if (TextUtils.isEmpty(id)) {
            T.showShort("订单ID不能为空");
            return;
        }

        if (AM.user().getLoginUserData() == null) {
            T.showShort("用户未登录,请前往登录!");
            return;
        }

        String msg = String.format("BillId=%s%s", id, AM.user().getLoginUserData().getId());
        String md5Result = MD5Util.md5(msg);
        PayNotifyBo payNotifyBo = new PayNotifyBo();
        payNotifyBo.setPayType(mPayType);
        payNotifyBo.setSign(md5Result);
        mPresenter.sendNotify(id, payNotifyBo);

    }

    @OnClick(R.id.btn_refused_reason)
    public void onViewClicked() {
        mPresenter.doRefauseMyBill(mBillId, mEdtRefusedReason.getText().toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
