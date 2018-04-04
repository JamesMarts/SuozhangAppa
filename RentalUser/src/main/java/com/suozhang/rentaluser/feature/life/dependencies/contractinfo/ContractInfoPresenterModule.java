/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.contractinfo;


import com.suozhang.rentaluser.feature.life.contract.ContractInfoContract;
import com.suozhang.rentaluser.feature.life.presenter.ContractInfoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:27
 */
@Module
public class ContractInfoPresenterModule {
    private final ContractInfoContract.View mView;

    public ContractInfoPresenterModule(ContractInfoContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public ContractInfoContract.Presenter provideContractInfoPresenter() {
        return new ContractInfoPresenter(mView);
    }

}
