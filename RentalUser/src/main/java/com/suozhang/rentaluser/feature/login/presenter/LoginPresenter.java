/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.presenter;

import android.text.TextUtils;

import com.suozhang.framework.entity.bo.LoginRequest;
import com.suozhang.framework.entity.bo.TokenInfo;
import com.suozhang.framework.entity.bo.UserAccount;
import com.suozhang.framework.entity.enums.CredentialType;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.utils.MD5Util;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.ValidatorUtil;
import com.suozhang.rentaluser.entity.bo.ThirdLoginBo;
import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.dependencies.DaggerLoginPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    @Inject

    LoginContract.Model mModel;


    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        DaggerLoginPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void initUserAccout() {

    }


    @Override
    public void login(String username, String password) {


        if (TextUtils.isEmpty(username)) {
            mView.showLoginError("请输入用户名！");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mView.showLoginError("请输入密码");
            return;
        } else {
            password = MD5Util.md5(password);
        }

        final UserAccount userAccount = new UserAccount(username, password);

        LoginRequest<UserAccount> loginRequest = new LoginRequest<>(userAccount, CredentialType.SYSTEM.value());

        mModel.doUserLogin(loginRequest).compose(mView.<TokenInfo>bindToLife()).subscribe(new Observer<TokenInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(TokenInfo tokenInfo) {
                mView.showUserInfo();
                loginSuccess(tokenInfo, userAccount);
            }

            @Override
            public void onError(Throwable e) {

                mView.dismissLoading();
                mView.showLoginError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });

    }

    @Override
    public void getAuthCode(String phone, int codeType) {


        if (TextUtils.isEmpty(phone)) {
            mView.showLoginError("请输入手机号！");
            return;
        }

        if (!ValidatorUtil.isMobile(phone)) {
            mView.showLoginError("手机号格式有误！");
            return;
        }
        mModel.doGetAuthCode(phone, codeType).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.showGetCodeSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showGetCodeError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void userDynamicLogin(String phone, String code) {
        if (TextUtils.isEmpty(phone)) {
            mView.showDynamicLoginError("请输入手机号！");
            return;
        }

        if (!ValidatorUtil.isMobile(phone)) {
            mView.showDynamicLoginError("手机号格式有误！");
            return;
        }

        if (TextUtils.isEmpty(code)) {
            mView.showDynamicLoginError("请输入6位验证码！");
            return;
        }

        final UserAccount userAccount = new UserAccount();

        userAccount.setPhone(phone);
        userAccount.setCode(code);

        LoginRequest<UserAccount> loginRequest = new LoginRequest<>(userAccount, CredentialType.PHONE.value());

        mModel.doUserDynamicLogin(loginRequest).compose(mView.<TokenInfo>bindToLife()).subscribe(new Observer<TokenInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(TokenInfo tokenInfo) {
                mView.showDynamicLoginSuccess("登录成功！");
                loginSuccess(tokenInfo, userAccount);
            }

            @Override
            public void onError(Throwable e) {

                mView.dismissLoading();
                mView.showDynamicLoginError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });

    }


    @Override
    public void userIsExistByOpenId(String openId) {
        mModel.doUserIsExistByOpenId(openId).compose(mView.<Boolean>bindToLife()).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Boolean s) {
                mView.showUserIsExistSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showUserIsExistError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void userIsBindPhoneByOpenId(String openId) {
        mModel.doUserIsBindPhoneByOpenId(openId).compose(mView.<Boolean>bindToLife()).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Boolean s) {
                mView.showUserIsBindPhoneSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showUserIsBindPhoneError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void userCreate(ThirdLoginBo thirdLoginBo) {
        mModel.doUserCreate(thirdLoginBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showCreateUserSuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showCreateUserError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void loginByWx(String openId, int type) {
        if (TextUtils.isEmpty(openId)) {
            mView.showLoginError("openId不能为空！");
            return;
        }


        final UserAccount userAccount = new UserAccount(openId);

        LoginRequest<UserAccount> loginRequest = new LoginRequest<>(userAccount, type);

        mModel.doUserLogin(loginRequest).compose(mView.<TokenInfo>bindToLife()).subscribe(new Observer<TokenInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(TokenInfo tokenInfo) {
                mView.showUserInfo();
                loginSuccess(tokenInfo, userAccount);
            }

            @Override
            public void onError(Throwable e) {

                mView.dismissLoading();
                mView.showLoginError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });

    }


    public void loginSuccess(TokenInfo tokenInfo, UserAccount userAccount) {

        AM.user().saveUserAccountCache(userAccount);
        AM.user().saveLoginResultCache(tokenInfo);
        T.showShort("登录成功！");
    }


}
