/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.city;


import com.suozhang.rentaluser.feature.rental.contract.CityContract;
import com.suozhang.rentaluser.feature.rental.presenter.CityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class CityPresenterModule {
    private final CityContract.View mView;

    public CityPresenterModule(CityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CityContract.Presenter provideCityPresenter() {
        return new CityPresenter(mView);
    }

}
