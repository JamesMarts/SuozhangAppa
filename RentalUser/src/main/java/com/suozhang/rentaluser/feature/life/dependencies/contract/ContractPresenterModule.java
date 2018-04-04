/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.contract;


import com.suozhang.rentaluser.feature.life.contract.ContractContract;
import com.suozhang.rentaluser.feature.life.presenter.ContractPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class ContractPresenterModule {
    private final ContractContract.View mView;

    public ContractPresenterModule(ContractContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ContractContract.Presenter provideContractPresenter() {
        return new ContractPresenter(mView);
    }

}
