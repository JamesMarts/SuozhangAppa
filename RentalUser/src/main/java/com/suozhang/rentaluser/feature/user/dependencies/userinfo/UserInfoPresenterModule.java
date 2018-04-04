/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.userinfo;


import com.suozhang.rentaluser.feature.user.contract.UserInfoContract;
import com.suozhang.rentaluser.feature.user.presenter.UserInfoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class UserInfoPresenterModule {
    private final UserInfoContract.View mView;

    public UserInfoPresenterModule(UserInfoContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public UserInfoContract.Presenter provideUserInfoPresenter(){
        return  new UserInfoPresenter(mView);
    }

}
