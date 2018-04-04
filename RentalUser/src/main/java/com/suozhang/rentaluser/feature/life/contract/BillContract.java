/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyRes;
import com.suozhang.rentaluser.entity.bo.WXPayBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface BillContract {

    interface Model {


        Observable<WXPayBo> doWxPay(String orderId, int type);

        Observable<PayNotifyRes> doSendNotify(String orderId, PayNotifyBo payNotifyBo);

        Observable<AlipayBo> doAlipay(String orderId, int type);

        Observable<MyLifeBo> doGetMyBillInfo(String id);

        Observable<String> doRefauseMyBill(String id, ContractInfoPramsBo contractInfoPramsBo);
    }

    interface View extends BaseView {


        void showSuccess(MyLifeBo contractBos);


        void showErrorMsg(String msg);


        void showRefauseSuccess(String contractBos);


        void showRefauseError(String msg);

        /**
         * 设置用户信息
         */

        void showWxPayResult(WXPayBo msg);

        void showAlipayResult(AlipayBo msg);

        void showNotitySuccess(PayNotifyRes msg);

        void showNotityError(String msg);

        /**
         * 显示错误信息
         */

        void showPayErrorMsg(String msg);
    }


    interface Presenter extends BasePresenter {

        void getMyBillInfo(String id);

        void doRefauseMyBill(String id, String refuseCause);

        void getWxPayInfo(String orderId);

        void getAlipayInfo(String orderId);

        void sendNotify(String orderId, PayNotifyBo payNotifyBo);
    }
}
