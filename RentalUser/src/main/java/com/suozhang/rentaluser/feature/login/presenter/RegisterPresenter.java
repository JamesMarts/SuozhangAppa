/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.presenter;

import android.text.TextUtils;

import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.ValidatorUtil;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.entity.bo.RegisterBo;
import com.suozhang.rentaluser.feature.login.contract.RegisterContract;
import com.suozhang.rentaluser.feature.login.dependencies.register.DaggerRegisterPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;

    @Inject

    RegisterContract.Model mModel;


    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
        DaggerRegisterPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void verifyPhone(String phone, int codeType) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入手机号码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }
        mModel.doVerifyPhone(phone, codeType).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showVerifyPhoneSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showVerifyPhoneError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });

    }

    @Override
    public void getVerifyCode(String phone, int codeType) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入手机号码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }
        mModel.doGetVerifyCode(phone, codeType).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showGetCodeSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showGetCodeError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void authVerifyCode(String phone, String code) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入手机号码！");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            T.showShort("请输入6位短信验证码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }
        mModel.doAuthVerifyCode(phone, code).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showVerifyCodeSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showVerifyCodeError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void register(String phone, String password, String rePassword, String code) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入要注册的手机号！");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            T.showShort("请输入密码！");
            return;
        }
        if (TextUtils.isEmpty(rePassword)) {
            T.showShort("请再次输入密码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }

        RegisterBo registerBo = new RegisterBo(phone, code, password, rePassword);

        mModel.doRegister(registerBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showRegisterSucess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showRegisterError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void resetPassword(String phone, String password, String rePassword, String code) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入要重置密码的手机号！");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            T.showShort("请输入密码！");
            return;
        }
        if (TextUtils.isEmpty(rePassword)) {
            T.showShort("请再次输入密码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }

        RegisterBo registerBo = new RegisterBo(phone, code, password, rePassword);
        Logger.e("ssss-->" + registerBo.toString());
        mModel.doResetPassword(registerBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showResetPasswordSucess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showResetPasswordError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void editPhone(String phone, String code) {
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入手机号码！");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            T.showShort("请输入6位短信验证码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }
        PasswordBo passwordBo = new PasswordBo();
        passwordBo.setPhone(phone);
        passwordBo.setCode(code);
        mModel.doEditPhone(passwordBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showBindPhoneSucess(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showBindPhoneError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void wechatBindPhone(String openId, String phone, String code) {
        if (TextUtils.isEmpty(openId)) {
            T.showShort("openId不能为空！");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            T.showShort("请输入手机号码！");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            T.showShort("请输入6位短信验证码！");
            return;
        }
        if (!ValidatorUtil.isMobile(phone)) {
            T.showShort("手机号格式错误！");
            return;
        }
        RegisterBo registerBo = new RegisterBo(phone, code);
        mModel.doWechatBindPhone(openId, registerBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showWxBindPhoneSucess(s);
                mView.dismissLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showWxBindPhoneError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

}
