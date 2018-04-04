/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.house;


import com.suozhang.rentaluser.feature.rental.contract.HouseContract;
import com.suozhang.rentaluser.feature.rental.presenter.HousePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class HousePresenterModule {
    private final HouseContract.View mView;

    public HousePresenterModule(HouseContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public HouseContract.Presenter provideHousePresenter() {
        return new HousePresenter(mView);
    }

}
