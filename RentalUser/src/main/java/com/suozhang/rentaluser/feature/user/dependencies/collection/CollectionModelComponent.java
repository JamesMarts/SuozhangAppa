/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.collection;

import com.suozhang.framework.framework.annotation.ModelScope;
import com.suozhang.rentaluser.feature.user.model.CollectionModel;
import com.suozhang.rentaluser.framework.api.dependencies.ApiComponent;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:36
 */
@ModelScope
@Component(dependencies = ApiComponent.class)
public interface CollectionModelComponent {

    void inject(CollectionModel collectionModel);
}