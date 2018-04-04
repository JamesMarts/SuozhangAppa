/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.bill;


import com.suozhang.rentaluser.feature.life.contract.BillContract;
import com.suozhang.rentaluser.feature.life.presenter.BillPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class BillPresenterModule {
    private final BillContract.View mView;

    public BillPresenterModule(BillContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public BillContract.Presenter provideBillPresenter() {
        return new BillPresenter(mView);
    }

}
