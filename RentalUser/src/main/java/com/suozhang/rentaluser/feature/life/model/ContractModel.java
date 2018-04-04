/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.ContractBo;
import com.suozhang.rentaluser.feature.life.contract.ContractContract;
import com.suozhang.rentaluser.feature.life.dependencies.contract.DaggerContractModelComponent;
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
public class ContractModel implements ContractContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public ContractModel() {

        DaggerContractModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<ContractBo>> doGetContractList(boolean IsCurrentContract) {
        return api.getContractList(IsCurrentContract).compose(RxDataProcessFactory.<List<ContractBo>>dataPrepAndIoToMainTransformer());
    }
}
