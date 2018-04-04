/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.payment;


import com.suozhang.rentaluser.feature.life.contract.PaymentContract;
import com.suozhang.rentaluser.feature.life.model.PaymentModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class PaymentModelModule {

    @Provides

    public PaymentContract.Model provideLifeModel() {
        return new PaymentModel();
    }
}
