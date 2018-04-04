/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.life;


import com.suozhang.rentaluser.feature.life.contract.LifeContract;
import com.suozhang.rentaluser.feature.life.presenter.LifePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class LifePresenterModule {
    private final LifeContract.View mView;

    public LifePresenterModule(LifeContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LifeContract.Presenter provideContractPresenter() {
        return new LifePresenter(mView);
    }

}
