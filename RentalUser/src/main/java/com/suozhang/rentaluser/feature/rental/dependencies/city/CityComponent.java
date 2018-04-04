/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.city;


import com.suozhang.rentaluser.common.widget.citypicker.CityPickerActivity;

import dagger.Component;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = CityPresenterModule.class)
public interface CityComponent {
    void inject(CityPickerActivity  activity);
}
