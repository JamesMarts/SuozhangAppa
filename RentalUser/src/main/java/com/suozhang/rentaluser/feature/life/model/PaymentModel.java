/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.BillingDetailBo;
import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;
import com.suozhang.rentaluser.feature.life.contract.PaymentContract;
import com.suozhang.rentaluser.feature.life.dependencies.payment.DaggerPaymentModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class PaymentModel implements PaymentContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public PaymentModel() {

        DaggerPaymentModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<PaymentDetailBo>> doGetPayMentList() {
        return api.getPayMentList().compose(RxDataProcessFactory.<List<PaymentDetailBo>>dataPrepAndIoToMainTransformer());
    }
}
