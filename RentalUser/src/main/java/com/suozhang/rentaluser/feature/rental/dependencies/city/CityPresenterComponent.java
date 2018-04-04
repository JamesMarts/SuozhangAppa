/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.city;

import com.suozhang.rentaluser.feature.rental.presenter.CityPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = CityModelModule.class)
public interface CityPresenterComponent {
    void inject(CityPresenter cityPresenter);
}
