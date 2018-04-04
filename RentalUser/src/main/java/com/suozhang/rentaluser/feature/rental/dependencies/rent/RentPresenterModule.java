/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.rent;


import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.presenter.RentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class RentPresenterModule {
    private final RentContract.View mView;

    public RentPresenterModule(RentContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public RentContract.Presenter provideRentPresenter() {
        return new RentPresenter(mView);
    }

}
