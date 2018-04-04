package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.user.contract.ModifyPhoneContract;
import com.suozhang.rentaluser.feature.user.dependencies.modifyphone.DaggerModifyPhoneComponent;
import com.suozhang.rentaluser.feature.user.dependencies.modifyphone.ModifyPhonePresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ModifyPhoneActivity extends BaseActivity implements ModifyPhoneContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.edt_old_phone)
    EditText mEdtOldPhone;
    @BindView(R.id.edt_new_phone)
    EditText mEdtNewPhone;
    @BindView(R.id.edt_code)
    EditText mEdtCode;
    @BindView(R.id.btn_send)
    Button mBtnSend;
    @BindView(R.id.btn_modify)
    Button mBtnModify;

    @Inject
    ModifyPhoneContract.Presenter mPersenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_modify_phone;
    }

    @Override
    protected void initInjector() {
        DaggerModifyPhoneComponent.builder()
                .modifyPhonePresenterModule(new ModifyPhonePresenterModule(this))
                .build().inject(this);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_modify_phone);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_send)
    public void onMBtnSendClicked() {
        String newPhone = mEdtNewPhone.getText().toString().trim();
        mPersenter.sendCode(newPhone);
    }

    @OnClick(R.id.btn_modify)
    public void onMBtnModifyClicked() {
        String oldPhone = mEdtOldPhone.getText().toString().trim();
        String newPhone = mEdtNewPhone.getText().toString().trim();
        String code = mEdtCode.getText().toString().trim();

        mPersenter.modifyPhone(oldPhone, newPhone, code);

    }

    @Override
    public void setResendEnabled(boolean enabled) {
        mBtnSend.setEnabled(enabled);
        if (enabled) {
            mBtnSend.setBackgroundResource(R.drawable.selector_btn_common_round_small_def);
            mBtnSend.setText("重新获取");
        } else {
            mBtnSend.setBackgroundResource(R.drawable.bg_common_round_no_enabled);
        }
    }

    @Override
    public void setResendCountdown(String countdown) {
        mBtnSend.setText(countdown);
    }

    @Override
    public void finishUi() {
        finish();
    }
}
