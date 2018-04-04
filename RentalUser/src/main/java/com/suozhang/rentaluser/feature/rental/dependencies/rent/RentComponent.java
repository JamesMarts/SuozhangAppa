/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.rent;


import com.suozhang.rentaluser.feature.rental.view.RentMapActivity;
import com.suozhang.rentaluser.feature.rental.view.RentalListActivity;

import dagger.Component;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = RentPresenterModule.class)
public interface RentComponent {
    void inject(RentalListActivity activity);
    void inject(RentMapActivity activity);
}
