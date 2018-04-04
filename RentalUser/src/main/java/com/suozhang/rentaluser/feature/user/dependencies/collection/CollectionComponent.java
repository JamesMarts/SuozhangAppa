/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.collection;


import com.suozhang.rentaluser.feature.user.view.CollectionFragment;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = CollectionPresenterModule.class)
public interface CollectionComponent {
    void inject(CollectionFragment collectionFragment);
}
