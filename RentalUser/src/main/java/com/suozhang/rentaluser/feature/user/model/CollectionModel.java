/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.feature.user.contract.CollectionContract;
import com.suozhang.rentaluser.feature.user.dependencies.collection.DaggerCollectionModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class CollectionModel implements CollectionContract.Model {


    @Inject
    UserApi api;

    @Inject
    public CollectionModel() {

        DaggerCollectionModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<HouseRoomBo>> doGetCollectionList() {
        return api.getCollection().compose(RxDataProcessFactory.<List<HouseRoomBo>>dataPrepAndIoToMainTransformer());
    }
}
