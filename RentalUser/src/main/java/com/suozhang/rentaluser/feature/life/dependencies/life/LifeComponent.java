/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.life;


import com.suozhang.rentaluser.feature.life.view.LifeFragment;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = LifePresenterModule.class)
public interface LifeComponent {
    void inject(LifeFragment lifeFragment);
}
