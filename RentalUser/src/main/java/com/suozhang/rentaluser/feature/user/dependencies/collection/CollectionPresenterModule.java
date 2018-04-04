/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.collection;


import com.suozhang.rentaluser.feature.user.contract.CollectionContract;
import com.suozhang.rentaluser.feature.user.presenter.CollectionPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class CollectionPresenterModule {
    private final CollectionContract.View mView;

    public CollectionPresenterModule(CollectionContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public CollectionContract.Presenter provideCollectionPresenter() {
        return new CollectionPresenter(mView);
    }

}
