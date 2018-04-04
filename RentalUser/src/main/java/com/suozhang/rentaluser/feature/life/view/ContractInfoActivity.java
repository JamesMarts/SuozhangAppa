package com.suozhang.rentaluser.feature.life.view;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.common.widget.CommonDialog;
import com.suozhang.rentaluser.common.widget.PreviewContractDialog;
import com.suozhang.rentaluser.entity.bo.ContractInfoBo;
import com.suozhang.rentaluser.entity.enums.ContractState;
import com.suozhang.rentaluser.feature.life.contract.ContractInfoContract;
import com.suozhang.rentaluser.feature.life.dependencies.contractinfo.ContractInfoPresenterModule;
import com.suozhang.rentaluser.feature.life.dependencies.contractinfo.DaggerContractInfoComponent;
import com.suozhang.rentaluser.feature.life.view.adapter.RentInfoAdapter;
import com.suozhang.rentaluser.feature.life.view.adapter.RentInfoCostAdapter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContractInfoActivity extends BaseActivity implements ContractInfoContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_renter_name)
    TextView mTvRenterName;
    @BindView(R.id.tv_renter_gender)
    TextView mTvRenterGender;
    @BindView(R.id.tv_renter_card)
    TextView mTvRenterCard;
    @BindView(R.id.tv_renter_validity)
    TextView mTvRenterValidity;
    @BindView(R.id.tv_renter_pay_way)
    TextView mTvRenterPayWay;
    @BindView(R.id.tv_renter_pay_period)
    TextView mTvRenterPayPeriod;
    @BindView(R.id.rv_rent_payment)
    RecyclerView mRvRentPayment;
    @BindView(R.id.rv_original_scale)
    RecyclerView mRvOriginalScale;
    @BindView(R.id.tv_rent_address)
    TextView mTvRentAddress;
    @BindView(R.id.tv_landlord_name)
    TextView mTvLandlordName;
    @BindView(R.id.tv_landlord_gender)
    TextView mTvLandlordGender;
    @BindView(R.id.tv_landlord_phone)
    TextView mTvLandlordPhone;
    @BindView(R.id.tv_contract_remark)
    TextView mTvContractRemark;
    @BindView(R.id.tv_rent_need_pay_money)
    TextView mTvRentNeedPayMoney;
    @BindView(R.id.tv_rent_total_money)
    TextView mTvRentTotalMoney;
    @BindView(R.id.tv_renter_state)
    TextView mTvRenterState;
    CommonDialog mDialog;
    @BindView(R.id.view_buttom_no)
    LinearLayout mViewButtomNo;
    @BindView(R.id.view_buttom_yes)
    LinearLayout mViewButtomYes;
    @BindView(R.id.tv_signing_date)
    TextView mTvSigningDate;
    @BindView(R.id.btn_to_call_phone)
    ImageButton mBtnToCallPhone;
    @BindView(R.id.btn_to_doubt)
    TextView mBtnToDoubt;
    @BindView(R.id.btn_to_pay)
    TextView mBtnToPay;
    @BindView(R.id.btn_refused_reason)
    TextView mBtnRefusedReason;
    @BindView(R.id.edt_refused_reason)
    EditText mEdtRefusedReason;
    @BindView(R.id.view_refused_reason)
    LinearLayout mViewRefusedReason;
    @BindView(R.id.sv_scroll)
    NestedScrollView mSvScroll;
    @BindView(R.id.view_buttom)
    LinearLayout mViewButtom;
    @BindView(R.id.tv_renter_zujin)
    TextView mTvRenterZujin;
    @BindView(R.id.tv_renter_pyajin)
    TextView mTvRenterPyajin;
    @BindView(R.id.tv_rent_name)
    TextView mTvRentName;
    private ContractInfoBo mData;

    private String mContractId = "";

    @Inject
    ContractInfoContract.Presenter mPresenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_contract_info;
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "合同详情", true, true);

    }

    @Override
    protected void initInjector() {
        DaggerContractInfoComponent.builder().contractInfoPresenterModule(new ContractInfoPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        mContractId = this.getIntent().getStringExtra("id");
        mPresenter.getContractInfoList(mContractId);
    }


    @OnClick({R.id.btn_to_call_phone, R.id.btn_to_doubt, R.id.btn_to_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_to_call_phone:
                if (mData != null) {
                    if (mData.getAppRentalLandlordView() != null) {
                        if (!TextUtils.isEmpty(mData.getAppRentalLandlordView().getPhone())) {
                            callPhone(mData.getAppRentalLandlordView().getPhone());
                        }
                    }
                }

                break;
            case R.id.btn_to_doubt:
                mSvScroll.post(new Runnable() {
                    @Override
                    public void run() {
                        mSvScroll.fullScroll(View.FOCUS_DOWN);
                    }
                });


                mBtnRefusedReason.setVisibility(View.VISIBLE);
                mViewButtomNo.setVisibility(View.GONE);
                mViewButtomYes.setVisibility(View.GONE);
                mViewRefusedReason.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_to_pay:
                if (mData != null)
                    mPresenter.postConfirmContract(mData.getId());
                break;
        }
    }

    private void initRentMoneyAdapter(List<ContractInfoBo.CostTypeInfoBo> billingDetailBos) {
        billingDetailBos.size();
        mRvRentPayment.setLayoutManager(new LinearLayoutManager(this));
        RentInfoCostAdapter rentInfoAdapter = new RentInfoCostAdapter(billingDetailBos, R.color.primary_highlight);
        mRvRentPayment.setAdapter(rentInfoAdapter);

    }

    private void initOriginalScaleAdapter(List<ContractInfoBo.AppMeterBo> billingDetailBos) {
        mRvOriginalScale.setLayoutManager(new LinearLayoutManager(this));
        RentInfoAdapter rentInfoAdapter = new RentInfoAdapter(billingDetailBos, R.color.text_primary);
        mRvOriginalScale.setAdapter(rentInfoAdapter);

    }

    @Override
    public void showSuccess(ContractInfoBo contractInfoBo) {
        mData = contractInfoBo;
        initViewData(mData);
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showConfirmSuccess(String msg) {
        T.showShort("确认成功");
        finish();
    }

    @Override
    public void showConfirmError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showRefauseSuccess(String msg) {
        T.showShort("发送成功！");
        finish();
    }

    @Override
    public void showRefauseError(String msg) {
        T.showShort(msg);
    }


    @Override
    public void showGetTemplateInfoSuccess(String msg) {
        final PreviewContractDialog commonDialog = new PreviewContractDialog(this, msg);
        commonDialog.show();
        commonDialog.setListener(new PreviewContractDialog.MyClickListenerInterface() {
            @Override
            public void doConfirm() {
                commonDialog.dismiss();
            }
        });
    }

    @Override
    public void showGetTemplateInfoError(String msg) {

    }

    private void initViewData(ContractInfoBo contractInfoBo) {
        if (contractInfoBo == null) {
            return;
        }

        if (contractInfoBo.getAppCheckInfo() != null) {
            mTvRenterName.setText(TextUtils.isEmpty(contractInfoBo.getAppCheckInfo().getCheckInfoPepoleName()) ? "" : contractInfoBo.getAppCheckInfo().getCheckInfoPepoleName());
            mTvRenterGender.setText(contractInfoBo.getAppCheckInfo().isSex() ? "男" : "女");
            mTvRenterCard.setText(TextUtils.isEmpty(contractInfoBo.getAppCheckInfo().getCardNumber()) ? "" : contractInfoBo.getAppCheckInfo().getCardNumber());
        }

        mTvRenterValidity.setText(DateUtil.getTimeStr(contractInfoBo.getStartDate()) + "-" + DateUtil.getTimeStr(contractInfoBo.getEndDate()));
        mTvRenterPayWay.setText(TextUtils.isEmpty(contractInfoBo.getDepositTypeName()) ? "" : contractInfoBo.getDepositTypeName());
        mTvRentName.setText(TextUtils.isEmpty(contractInfoBo.getHousingResourceName()) ? "未知" : contractInfoBo.getHousingResourceName());
        mTvRentNeedPayMoney.setText(contractInfoBo.getPayRentMoney() + "元");
        mTvRentTotalMoney.setText((contractInfoBo.getDepositMoney() + contractInfoBo.getPayRentMoney()) + "元");
        mTvRenterZujin.setText(contractInfoBo.getRentMoney() + "元");
        mTvRenterPyajin.setText(contractInfoBo.getDepositMoney() + "元");
        initOriginalScaleAdapter(contractInfoBo.getAppMeter());
        initRentMoneyAdapter(contractInfoBo.getCostTypeInfo());
        mTvRentAddress.setText(TextUtils.isEmpty(contractInfoBo.getAddress()) ? "" : contractInfoBo.getAddress());
        if (contractInfoBo.getAppRentalLandlordView() != null) {
            mTvLandlordName.setText(TextUtils.isEmpty(contractInfoBo.getAppRentalLandlordView().getName()) ? "" : contractInfoBo.getAppRentalLandlordView().getName());
            mTvLandlordGender.setText(contractInfoBo.getAppRentalLandlordView().isSex() ? "男" : "女");
            mTvLandlordPhone.setText(TextUtils.isEmpty(contractInfoBo.getAppRentalLandlordView().getPhone()) ? "" : contractInfoBo.getAppRentalLandlordView().getPhone());
        }
        mTvContractRemark.setText(TextUtils.isEmpty(contractInfoBo.getRemark()) ? "暂无" : contractInfoBo.getRemark());
        mTvRenterState.setText(ContractState.getName(contractInfoBo.getContractState()));
        if (contractInfoBo.getContractState() == ContractState.Validate.getIndex()) {
            mViewButtomNo.setVisibility(View.GONE);
            mViewButtomYes.setVisibility(View.VISIBLE);
            mTvSigningDate.setText("签订日期:" + DateUtil.getTimeStr(contractInfoBo.getCreateTime()));
        } else if (contractInfoBo.getContractState() == ContractState.Affirm.getIndex()) {
            mViewButtomNo.setVisibility(View.VISIBLE);
            mViewButtomYes.setVisibility(View.GONE);
        } else if (contractInfoBo.getContractState() == ContractState.Reject.getIndex()) {
            mViewButtom.setVisibility(View.GONE);
        } else if (contractInfoBo.getContractState() == ContractState.Termination.getIndex()) {
            mViewButtom.setVisibility(View.GONE);
        }

    }

    private void callPhone(final String phone) {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CALL_PHONE)
                .subscribe(granted -> {
                    if (granted) {
                        if (!TextUtils.isEmpty(phone)) {
                            mDialog = new CommonDialog(ContractInfoActivity.this, "拔打房东电话：" + phone);
                            mDialog.show();

                            mDialog.setListener(new CommonDialog.MyClickListenerInterface() {
                                @Override
                                public void doConfirm() {
                                    callToPhone(phone);
                                    mDialog.dismiss();
                                }
                            });


                        }
                    } else {

                    }
                });


    }

    public void callToPhone(String phone) {
        if (!TextUtils.isEmpty(phone)) {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            T.showShort("手机号不能为空！");
            return;
        }

    }


    @OnClick(R.id.btn_preview_contract)
    public void onViewClicked() {
        if (mData != null)
            mPresenter.getTemplateInfo(mData.getId());
    }


    @OnClick(R.id.btn_refused_reason)
    public void onViewReasonClicked() {
        if (TextUtils.isEmpty(mEdtRefusedReason.getText().toString())) {
            T.showShort("请输入拒绝原因！");
            return;
        }

        mPresenter.postRefauseContract(mData.getId(), mEdtRefusedReason.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
