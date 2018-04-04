package com.suozhang.rentaluser.feature.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.RxHelper;
import com.suozhang.rentaluser.entity.enums.GetCodeType;
import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.dependencies.DaggerLoginComponent;
import com.suozhang.rentaluser.feature.login.dependencies.LoginPresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DynamicLoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginContract.Presenter mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_login_phone)
    PowerfulEditText mEtLoginUsername;
    @BindView(R.id.edt_code)
    PowerfulEditText mEtLoginCode;
    @BindView(R.id.btn_send)
    Button mBtLoginGetCode;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login_dynamic;
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, "登录", true);
    }

    @Override
    protected void initInjector() {
        DaggerLoginComponent.builder().loginPresenterModule(new LoginPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mEtLoginUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() < 11) {
                    mBtLoginGetCode.setEnabled(false);
                    mBtLoginGetCode.setBackgroundResource(R.drawable.login_get_phone_code);
                    mBtLoginGetCode.setTextColor(getResources().getColor(R.color.text_secondary));
                } else if (s.toString().length() == 11) {
                    mBtLoginGetCode.setBackgroundResource(R.drawable.booking_order_button_bg);
                    mBtLoginGetCode.setTextColor(getResources().getColor(R.color.primary_comparison));
                    mBtLoginGetCode.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void showUserInfo() {

    }


    @Override
    public void showGetCodeSuccess(String msg) {
        T.showShort("获取验证码成功！");
        RxHelper.countdown(60)
                .compose(this.<Integer>bindToLife()).subscribe(observer);
    }

    //创建一个下游 Observer
    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            mBtLoginGetCode.setEnabled(false);
            mBtLoginGetCode.setBackgroundResource(R.drawable.login_get_phone_code);
            mBtLoginGetCode.setTextColor(getResources().getColor(R.color.text_secondary));
        }

        @Override
        public void onNext(Integer value) {


            mBtLoginGetCode.setText(value + "s后重试");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

            if (mEtLoginUsername.getText().toString().length() == 11) {
                mBtLoginGetCode.setBackgroundResource(R.drawable.booking_order_button_bg);
                mBtLoginGetCode.setTextColor(getResources().getColor(R.color.primary_comparison));
                mBtLoginGetCode.setEnabled(true);
            }
            mBtLoginGetCode.setText("获取验证码");
        }
    };

    @Override
    public void showGetCodeError(String msg) {
        T.showShort("获取验证码失败！" + msg);
    }

    @Override
    public void showLoginError(String msg) {

    }

    @Override
    public void showDynamicLoginSuccess(String msg) {
        T.showShort(msg);
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", true);
        resultIntent.putExtras(bundle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void showDynamicLoginError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showUserIsExistSuccess(Boolean msg) {

    }

    @Override
    public void showUserIsExistError(String msg) {

    }

    @Override
    public void showUserIsBindPhoneSuccess(Boolean msg) {
    }

    @Override
    public void showUserIsBindPhoneError(String msg) {

    }

    @Override
    public void showCreateUserSuccess(String msg) {

    }

    @Override
    public void showCreateUserError(String msg) {

    }


    @OnClick(R.id.btn_send)
    public void onViewClicked() {
        String phone = mEtLoginUsername.getText().toString();
        if (phone.length() < 11) {
            // mBtLoginGetCode.setClickable(false);
            mBtLoginGetCode.setBackgroundResource(R.drawable.login_get_phone_code);
            mBtLoginGetCode.setTextColor(getResources().getColor(R.color.text_secondary));
        }
        mPresenter.getAuthCode(phone, GetCodeType.Login.value());
    }


    @OnClick(R.id.bt_login_dynamic)
    public void onViewLoginClicked() {

        mPresenter.userDynamicLogin(mEtLoginUsername.getText().toString(), mEtLoginCode.getText().toString());

    }


}
