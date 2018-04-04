/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.house;


import com.suozhang.rentaluser.feature.rental.contract.HouseContract;
import com.suozhang.rentaluser.feature.rental.model.HouseModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class HouseModelModule {

    @Provides

    public HouseContract.Model provideHouseModel() {
        return new HouseModel();
    }
}
