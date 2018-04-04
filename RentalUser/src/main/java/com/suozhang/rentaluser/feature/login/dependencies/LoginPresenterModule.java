/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies;

import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class LoginPresenterModule {
    private final LoginContract.View mView;

    public LoginPresenterModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LoginContract.Presenter provideLoginContractPresenter() {
        return new LoginPresenter(mView);
    }

}
