/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.ContractInfoBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.feature.life.contract.ContractInfoContract;
import com.suozhang.rentaluser.feature.life.dependencies.contractinfo.DaggerContractInfoModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class ContractInfoModel implements ContractInfoContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public ContractInfoModel() {

        DaggerContractInfoModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<ContractInfoBo> doGetContractInfoList(String contractId) {
        return api.getContractInfo(contractId).compose(RxDataProcessFactory.<ContractInfoBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doConfirmContract(String contractId) {
        return api.postConfirmContract(contractId).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doRefauseContract(String contractId, ContractInfoPramsBo contractInfoBo) {
        return api.postCancleContract(contractId,contractInfoBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doGetTemplateInfoSuccess(String contractId) {
        return api.getContrcTemplateInfo(contractId).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
