/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.banner;


import com.suozhang.rentaluser.feature.rental.contract.BannerContract;
import com.suozhang.rentaluser.feature.rental.presenter.BannerPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class BannerPresenterModule {
    private final BannerContract.View mView;

    public BannerPresenterModule(BannerContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public BannerContract.Presenter provideBannerPresenter() {
        return new BannerPresenter(mView);
    }

}
