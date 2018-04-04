/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.checkinpepole;


import com.suozhang.rentaluser.feature.life.contract.CheckinPepoleContract;
import com.suozhang.rentaluser.feature.life.presenter.CheckinPepolePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/14 10:4
 */
@Module
public class CheckinPepolePresenterModule {

    private final CheckinPepoleContract.View mView;

    public CheckinPepolePresenterModule(CheckinPepoleContract.View view) {
        this.mView = view;
    }

    @Provides
    public CheckinPepoleContract.Presenter providePresenter() {
        return new CheckinPepolePresenter(mView);
    }
}
