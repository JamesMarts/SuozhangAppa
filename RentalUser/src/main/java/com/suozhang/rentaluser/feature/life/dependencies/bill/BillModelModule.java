/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.bill;


import com.suozhang.rentaluser.feature.life.contract.BillContract;
import com.suozhang.rentaluser.feature.life.model.BillModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class BillModelModule {

    @Provides

    public BillContract.Model provideBillModel() {
        return new BillModel();
    }
}
