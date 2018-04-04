/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.model;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.ReportBo;
import com.suozhang.rentaluser.feature.rental.contract.ReportContract;
import com.suozhang.rentaluser.feature.rental.dependencies.report.DaggerReportModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.RentApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:42
 */
public class ReportModel implements ReportContract.Model {

    @Inject
    RentApi api;

    @Inject
    public ReportModel() {

        DaggerReportModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }


    @Override
    public Observable<List<BaseBo>> doGetReportType() {
        return api.getReportType().compose(RxDataProcessFactory.<List<BaseBo>>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doReportHouse(ReportBo reportBo) {
        return api.addReport(reportBo).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }
}
