/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.payment;


import com.suozhang.rentaluser.feature.life.contract.PaymentContract;
import com.suozhang.rentaluser.feature.life.presenter.PaymentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class PaymentPresenterModule {
    private final PaymentContract.View mView;

    public PaymentPresenterModule(PaymentContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public PaymentContract.Presenter providePaymentPresenter() {
        return new PaymentPresenter(mView);
    }

}
