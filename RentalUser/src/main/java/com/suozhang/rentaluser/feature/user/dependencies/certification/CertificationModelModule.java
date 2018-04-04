/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.certification;


import com.suozhang.rentaluser.feature.user.contract.CertificationContract;
import com.suozhang.rentaluser.feature.user.model.CertificationModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class CertificationModelModule {

    @Provides

    public CertificationContract.Model provideCertificationModel() {
        return new CertificationModel();
    }
}
