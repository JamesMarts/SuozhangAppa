/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.feature.life.contract.LifeContract;
import com.suozhang.rentaluser.feature.life.dependencies.life.DaggerLifeModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class LifeModel implements LifeContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public LifeModel() {

        DaggerLifeModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<MyLifeBo> doGetMyRentState() {
        return api.getMyBill().compose(RxDataProcessFactory.<MyLifeBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<Integer> doGetUnreadMessageCount() {
        return api.GetUnreadMessageCount().compose(RxDataProcessFactory.<Integer>dataPrepAndIoToMainTransformer());
    }
}
