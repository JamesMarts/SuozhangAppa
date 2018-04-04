/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.ReportBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface ReportContract {

    interface Model {

        Observable<List<BaseBo>> doGetReportType();

        Observable<String> doReportHouse(ReportBo reportBo);

    }

    interface View extends BaseView {


        void showSuccess(List<BaseBo> baseBos);

        void showErrorMsg(String msg);


        void showReportSuccess(String msg);

        void showReportErrorMsg(String msg);
    }


    interface Presenter extends BasePresenter {
        void doGetReportType();

        void doReportHouse(String reportTypeId,String houdeId ,String reason);
    }
}
