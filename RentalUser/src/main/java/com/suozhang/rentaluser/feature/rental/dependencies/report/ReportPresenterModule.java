/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.report;


import com.suozhang.rentaluser.feature.rental.contract.ReportContract;
import com.suozhang.rentaluser.feature.rental.presenter.ReportPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class ReportPresenterModule {
    private final ReportContract.View mView;

    public ReportPresenterModule(ReportContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ReportContract.Presenter provideReportPresenter() {
        return new ReportPresenter(mView);
    }

}
