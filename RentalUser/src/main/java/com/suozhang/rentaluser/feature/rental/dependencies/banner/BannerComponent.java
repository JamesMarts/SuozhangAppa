/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.dependencies.banner;


import com.suozhang.rentaluser.feature.rental.view.RentsFragment;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = BannerPresenterModule.class)
public interface BannerComponent {
    void inject(RentsFragment rentsFragment);
}