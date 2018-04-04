/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.RxHelper;
import com.suozhang.rentaluser.entity.enums.GetCodeType;
import com.suozhang.rentaluser.feature.login.contract.RegisterContract;
import com.suozhang.rentaluser.feature.login.dependencies.register.DaggerRegisterComponent;
import com.suozhang.rentaluser.feature.login.dependencies.register.RegisterPresenterModule;
import com.suozhang.rentaluser.framework.Config;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rb_register_input_phone)
    RadioButton mRbRegisterInputPhone;
    @BindView(R.id.rb_register_input_code)
    RadioButton mRbRegisterInputCode;
    @BindView(R.id.rb_register_input_pasword)
    RadioButton mRbRegisterInputPasword;
    @BindView(R.id.et_register_phone)
    PowerfulEditText mEtRegisterPhone;
    @BindView(R.id.view_register_phone)
    LinearLayout mViewRegisterPhone;
    @BindView(R.id.tv_register_show_phone)
    TextView mTvRegisterShowPhone;
    @BindView(R.id.et_login_usernamsse)
    PowerfulEditText mEtLoginUsernamsse;
    @BindView(R.id.view_register_code)
    LinearLayout mViewRegisterCode;
    @BindView(R.id.et_register_password)
    PowerfulEditText mEtRegisterPassword;
    @BindView(R.id.et_register_repassword)
    PowerfulEditText mEtRegisterRepassword;
    @BindView(R.id.view_register_pasword)
    LinearLayout mViewRegisterPasword;

    @Inject
    RegisterContract.Presenter mPresenter;
    private String mOpenId = "";

    private static final int REGISTER_PHONE = 0;
    private static final int REGISTER_CODE = 1;
    private static final int REGISTER_PASSWORD = 2;
    private static final int REGISTER_WECHAT = 3;
    @BindView(R.id.bt_register_send_code)
    Button mBtRegisterSendCode;
    @BindView(R.id.bt_register_get_code)
    CheckBox mBtRegisterGetCode;
    @BindView(R.id.bt_register_submit_code)
    Button mBtRegisterSubmitCode;
    @BindView(R.id.bt_register_register)
    Button mBtRegisterRegister;
    @BindView(R.id.tv_show_cer)
    TextView mTvShowCer;
    private String mPhone = "";
    private String mCode;

    private int isReg = Config.PHONE_TYPE_REGISTER;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initInjector() {
        DaggerRegisterComponent.builder().registerPresenterModule(new RegisterPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        isReg = this.getIntent().getIntExtra("reg", 1);
        mOpenId = this.getIntent().getStringExtra("openId");
        if (isReg == Config.PHONE_TYPE_REGISTER) {
            initToolBar(mToolbar, "注册", true, true);
            mBtRegisterRegister.setText("注册");
            mRbRegisterInputPasword.setText("设置密码  >");
            mTvShowCer.setVisibility(View.VISIBLE);
        } else if (isReg == Config.PHONE_TYPE_RESET) {
            initToolBar(mToolbar, "重置密码", true, true);
            mBtRegisterRegister.setText("完成");
            mRbRegisterInputPasword.setText("重置密码  >");
            mTvShowCer.setVisibility(View.GONE);
        } else if (isReg == Config.PHONE_TYPE_REBIND) {
            initToolBar(mToolbar, "换绑手机", true, true);
            mBtRegisterRegister.setText("完成");
            mRbRegisterInputPasword.setVisibility(View.GONE);
            mTvShowCer.setVisibility(View.GONE);
        } else if (isReg == Config.PHONE_TYPE_WECHAT) {
            initToolBar(mToolbar, "绑定手机号码", true, true);
            mBtRegisterRegister.setText("完成");
            mRbRegisterInputPasword.setVisibility(View.GONE);
            mTvShowCer.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initView() {
        super.initView();
        init(REGISTER_PHONE);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }


    @OnClick({R.id.bt_register_send_code, R.id.bt_register_get_code, R.id.bt_register_submit_code, R.id.bt_register_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_register_send_code:
                mPhone = mEtRegisterPhone.getText().toString();
                if (isReg == Config.PHONE_TYPE_REGISTER) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.Register.value());
                } else if (isReg == Config.PHONE_TYPE_RESET) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.ResetPwd.value());
                } else if (isReg == Config.PHONE_TYPE_REBIND) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.Register.value());
                } else if (isReg == Config.PHONE_TYPE_WECHAT) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.WeChatBind.value());
                }

                break;
            case R.id.bt_register_get_code:
                if (isReg == Config.PHONE_TYPE_REGISTER) {
                    mPresenter.getVerifyCode(mPhone, GetCodeType.Register.value());
                } else if (isReg == Config.PHONE_TYPE_RESET) {
                    mPresenter.getVerifyCode(mPhone, GetCodeType.ResetPwd.value());
                } else if (isReg == Config.PHONE_TYPE_REBIND) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.EditPhone.value());
                } else if (isReg == Config.PHONE_TYPE_WECHAT) {
                    mPresenter.verifyPhone(mPhone, GetCodeType.WeChatBind.value());
                }

                break;
            case R.id.bt_register_submit_code:
                mCode = mEtLoginUsernamsse.getText().toString();
                if (isReg == Config.PHONE_TYPE_REBIND) {
                    mPresenter.editPhone(mPhone, mCode);
                } else if (isReg == Config.PHONE_TYPE_WECHAT) {
                    if (!TextUtils.isEmpty(mOpenId)) {
                        mPresenter.wechatBindPhone(mOpenId, mPhone, mCode);
                    }
                } else {
                    mPresenter.authVerifyCode(mPhone, mCode);
                }

                break;
            case R.id.bt_register_register:
                String password = mEtRegisterPassword.getText().toString();
                String rePassword = mEtRegisterRepassword.getText().toString();

                Logger.e("password"+password);
                Logger.e("rePassword"+rePassword);
                if (isReg == Config.PHONE_TYPE_REGISTER) {
                    mPresenter.register(mPhone, password, rePassword, mCode);
                } else if (isReg == Config.PHONE_TYPE_RESET) {
                    Logger.e("mCode--->" + mCode);
                    mPresenter.resetPassword(mPhone, password, rePassword, mCode);
                }

                break;
        }
    }


    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void showVerifyPhoneSuccess(String msg) {
        if (!TextUtils.isEmpty(mPhone)) {
            mTvRegisterShowPhone.setText("验证码已发送至:" + mPhone);
            init(REGISTER_CODE);
            if (isReg == Config.PHONE_TYPE_REGISTER) {
                mPresenter.getVerifyCode(mPhone, GetCodeType.Register.value());
            } else if (isReg == Config.PHONE_TYPE_RESET) {
                mPresenter.getVerifyCode(mPhone, GetCodeType.ResetPwd.value());
            } else if (isReg == Config.PHONE_TYPE_REBIND) {
                mPresenter.getVerifyCode(mPhone, GetCodeType.EditPhone.value());
            } else if (isReg == Config.PHONE_TYPE_WECHAT) {
                mPresenter.getVerifyCode(mPhone, GetCodeType.WeChatBind.value());
            }

        }
    }

    @Override
    public void showVerifyPhoneError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showGetCodeSuccess(String msg) {
        T.showShort("发送短信验证码成功");
        RxHelper.countdown(60)
                .compose(this.<Integer>bindToLife()).subscribe(observer);
    }

    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            mBtRegisterGetCode.setEnabled(false);
            mBtRegisterGetCode.setChecked(false);
        }

        @Override
        public void onNext(Integer value) {
            mBtRegisterGetCode.setText(value + "s后重试");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            mBtRegisterGetCode.setEnabled(true);
            mBtRegisterGetCode.setChecked(true);
            mBtRegisterGetCode.setText("重新获取");
        }

    };

    @Override
    public void showGetCodeError(String msg) {
        T.showShort(msg);
        mBtRegisterGetCode.setEnabled(true);
        mBtRegisterGetCode.setChecked(true);
        mBtRegisterGetCode.setText("重新获取");
    }

    @Override
    public void showVerifyCodeSuccess(String msg) {
        init(REGISTER_PASSWORD);
    }

    @Override
    public void showVerifyCodeError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showRegisterSucess(String msg) {
        T.showShort("注册成功！");
        finishActivity();
    }

    @Override
    public void showRegisterError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showResetPasswordSucess(String msg) {
        T.showShort("密码重置成功!");
        finishActivity();
    }

    @Override
    public void showResetPasswordError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showBindPhoneSucess(String msg) {
        T.showShort("修改成功！");
        finishActivity();
    }

    @Override
    public void showBindPhoneError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showWxBindPhoneSucess(String msg) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("bind", true);
        bundle.putString("openId", mOpenId);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
        finish();
    }

    @Override
    public void showWxBindPhoneError(String msg) {
        T.showShort(msg);
    }


    private void init(int type) {
        switch (type) {
            case REGISTER_PHONE:
                mViewRegisterPhone.setVisibility(View.VISIBLE);
                mViewRegisterCode.setVisibility(View.GONE);
                mViewRegisterPasword.setVisibility(View.GONE);
                mRbRegisterInputPhone.setChecked(true);
                mRbRegisterInputCode.setChecked(false);
                mRbRegisterInputPasword.setChecked(false);
                break;
            case REGISTER_CODE:
                mViewRegisterPhone.setVisibility(View.GONE);
                mViewRegisterCode.setVisibility(View.VISIBLE);
                mViewRegisterPasword.setVisibility(View.GONE);
                mRbRegisterInputPhone.setChecked(false);
                mRbRegisterInputCode.setChecked(true);
                mRbRegisterInputPasword.setChecked(false);
                break;
            case REGISTER_PASSWORD:
                mViewRegisterPhone.setVisibility(View.GONE);
                mViewRegisterCode.setVisibility(View.GONE);
                mViewRegisterPasword.setVisibility(View.VISIBLE);
                mRbRegisterInputPhone.setChecked(false);
                mRbRegisterInputCode.setChecked(false);
                mRbRegisterInputPasword.setChecked(true);

                break;
            case REGISTER_WECHAT:
                mViewRegisterPhone.setVisibility(View.GONE);
                mViewRegisterCode.setVisibility(View.GONE);
                mViewRegisterPasword.setVisibility(View.VISIBLE);
                mRbRegisterInputPhone.setChecked(false);
                mRbRegisterInputCode.setChecked(false);
                mRbRegisterInputPasword.setChecked(true);

                break;
        }
    }


}
