/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.rent;


import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.model.RentModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class RentModelModule {

    @Provides

    public RentContract.Model provideRentModel() {
        return new RentModel();
    }
}
