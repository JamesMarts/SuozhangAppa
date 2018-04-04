/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyRes;
import com.suozhang.rentaluser.entity.bo.WXPayBo;
import com.suozhang.rentaluser.feature.life.contract.BillContract;
import com.suozhang.rentaluser.feature.life.dependencies.bill.DaggerBillPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class BillPresenter implements BillContract.Presenter {

    private BillContract.View mView;

    @Inject

    BillContract.Model mModel;


    public BillPresenter(BillContract.View mView) {
        this.mView = mView;

         DaggerBillPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getMyBillInfo(String id) {
        if (TextUtils.isEmpty(id)) {
            return;
        }
        mModel.doGetMyBillInfo(id).compose(mView.<MyLifeBo>bindToLife()).subscribe(new Observer<MyLifeBo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(MyLifeBo lifeBo) {
                mView.dismissLoading();
                mView.showSuccess(lifeBo);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void doRefauseMyBill(String id, String refuseCause) {
        if (TextUtils.isEmpty(id)) {
            return;
        }

        if (TextUtils.isEmpty(refuseCause)) {
            return;
        }
        ContractInfoPramsBo contractInfoPramsBo = new ContractInfoPramsBo(refuseCause);
        mModel.doRefauseMyBill(id, contractInfoPramsBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String lifeBo) {
                mView.dismissLoading();
                mView.showRefauseSuccess(lifeBo);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showRefauseError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void getWxPayInfo(String orderId) {

        mModel.doWxPay(orderId,1).compose(mView.<WXPayBo>bindToLife()).subscribe(new Observer<WXPayBo>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull WXPayBo s) {
                mView.showWxPayResult(s);
                mView.dismissLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showPayErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void getAlipayInfo(String orderId) {
        mModel.doAlipay(orderId, 2).compose(mView.<AlipayBo>bindToLife()).subscribe(new Observer<AlipayBo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(AlipayBo s) {

                mView.showAlipayResult(s);
                mView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.showPayErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void sendNotify(String orderId, PayNotifyBo payNotifyBo) {
        mModel.doSendNotify(orderId, payNotifyBo).compose(mView.<PayNotifyRes>bindToLife()).subscribe(new Observer<PayNotifyRes>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull PayNotifyRes s) {
                mView.showNotitySuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showNotityError(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
