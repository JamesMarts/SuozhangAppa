/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.dependencies.bill;


import com.suozhang.rentaluser.feature.life.view.BillingDetailActivity;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = BillPresenterModule.class)
public interface BillComponent {
    void inject(BillingDetailActivity billingDetailActivity);
}
