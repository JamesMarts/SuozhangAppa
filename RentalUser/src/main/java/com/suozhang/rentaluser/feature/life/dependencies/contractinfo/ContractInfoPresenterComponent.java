/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.contractinfo;

import com.suozhang.rentaluser.feature.life.presenter.ContractInfoPresenter;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:53
 */
@Component(modules = ContractInfoModelModule.class)
public interface ContractInfoPresenterComponent {
    void inject(ContractInfoPresenter contractInfoPresenter);
}
