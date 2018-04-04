/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.MyRoomBo;
import com.suozhang.rentaluser.feature.life.contract.MyRoomContract;
import com.suozhang.rentaluser.feature.life.dependencies.room.DaggerMyRoomModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class MyRoomModel implements MyRoomContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public MyRoomModel() {

        DaggerMyRoomModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<MyRoomBo> doGetMyRoomInfo() {
        return api.getMyRoomInfo().compose(RxDataProcessFactory.<MyRoomBo>dataPrepAndIoToMainTransformer());
    }
}
