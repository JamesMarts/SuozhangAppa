/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.report;


import com.suozhang.rentaluser.feature.rental.contract.ReportContract;
import com.suozhang.rentaluser.feature.rental.model.ReportModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class ReportModelModule {

    @Provides

    public ReportContract.Model provideReportModel() {
        return new ReportModel();
    }
}
