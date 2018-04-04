/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyRes;
import com.suozhang.rentaluser.entity.bo.WXPayBo;
import com.suozhang.rentaluser.feature.life.contract.BillContract;
import com.suozhang.rentaluser.feature.life.dependencies.bill.DaggerBillModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class BillModel implements BillContract.Model {

    @Inject
    LifeApi api;

    @Inject
    public BillModel() {

          DaggerBillModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }

    @Override
    public Observable<WXPayBo> doWxPay(String orderId, int type) {
        return api.getWxPayInfo(orderId,type).compose(RxDataProcessFactory.<WXPayBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<PayNotifyRes> doSendNotify(String orderId, PayNotifyBo payNotifyBo) {
        return api.sendPayNotify(orderId,payNotifyBo).compose(RxDataProcessFactory.<PayNotifyRes>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<AlipayBo> doAlipay(String orderId, int type) {
        return api.getAliPayInfo(orderId,type).compose(RxDataProcessFactory.<AlipayBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<MyLifeBo> doGetMyBillInfo(String id) {
        return api.getMyBillInfo(id).compose(RxDataProcessFactory.<MyLifeBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doRefauseMyBill(String id, ContractInfoPramsBo contractInfoPramsBo) {
        return api.refauseMyBill(id, contractInfoPramsBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
