/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.bill;

import com.suozhang.rentaluser.feature.life.presenter.BillPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = BillModelModule.class)
public interface BillPresenterComponent {
    void inject(BillPresenter billPresenter);
}
