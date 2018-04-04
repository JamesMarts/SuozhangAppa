/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.report;

import com.suozhang.rentaluser.feature.rental.presenter.ReportPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = ReportModelModule.class)
public interface ReportPresenterComponent {
    void inject(ReportPresenter presenter);
}
