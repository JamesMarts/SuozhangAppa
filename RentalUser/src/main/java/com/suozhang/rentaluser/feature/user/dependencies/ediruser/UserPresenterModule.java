/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.ediruser;


import com.suozhang.rentaluser.feature.user.contract.UserCenterContract;
import com.suozhang.rentaluser.feature.user.presenter.UserPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class UserPresenterModule {
    private final UserCenterContract.View mView;

    public UserPresenterModule(UserCenterContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public UserCenterContract.Presenter provideUserPresenter() {
        return new UserPresenter(mView);
    }

}
