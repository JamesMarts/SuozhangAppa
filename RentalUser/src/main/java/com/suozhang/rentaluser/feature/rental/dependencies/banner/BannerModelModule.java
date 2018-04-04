/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.banner;


import com.suozhang.rentaluser.feature.rental.contract.BannerContract;
import com.suozhang.rentaluser.feature.rental.model.BannerModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class BannerModelModule {

    @Provides

    public BannerContract.Model provideBannerModel() {
        return new BannerModel();
    }
}
