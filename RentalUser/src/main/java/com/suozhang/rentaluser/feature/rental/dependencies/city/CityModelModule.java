/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.city;


import com.suozhang.rentaluser.feature.rental.contract.CityContract;
import com.suozhang.rentaluser.feature.rental.model.CityModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class CityModelModule {

    @Provides

    public CityContract.Model provideCityModel() {
        return new CityModel();
    }
}
