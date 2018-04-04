/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.dependencies.register;


import com.suozhang.rentaluser.feature.login.contract.RegisterContract;
import com.suozhang.rentaluser.feature.login.presenter.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class RegisterPresenterModule {
    private final RegisterContract.View mView;

    public RegisterPresenterModule(RegisterContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public RegisterContract.Presenter provideRegisterPresenter(){
        return  new RegisterPresenter(mView);
    }

}
