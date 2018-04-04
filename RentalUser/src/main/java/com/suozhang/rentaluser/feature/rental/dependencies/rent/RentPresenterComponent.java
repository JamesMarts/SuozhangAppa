/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.rent;

import com.suozhang.rentaluser.feature.rental.presenter.RentPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = RentModelModule.class)
public interface RentPresenterComponent {
    void inject(RentPresenter presenter);
}
