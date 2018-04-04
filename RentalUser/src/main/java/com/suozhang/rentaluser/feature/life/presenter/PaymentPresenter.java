/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;
import com.suozhang.rentaluser.feature.life.contract.PaymentContract;
import com.suozhang.rentaluser.feature.life.dependencies.payment.DaggerPaymentPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class PaymentPresenter implements PaymentContract.Presenter {

    private PaymentContract.View mView;

    @Inject

    PaymentContract.Model mModel;


    public PaymentPresenter(PaymentContract.View mView) {
        this.mView = mView;

         DaggerPaymentPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getPayMentList() {
        mModel.doGetPayMentList().compose(mView.<List<PaymentDetailBo>>bindToLife()).subscribe(new Observer<List<PaymentDetailBo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(List<PaymentDetailBo> myLifeBo) {
                mView.dismissLoading();
                if (myLifeBo.size()>0){
                    mView.showSuccess(myLifeBo);
                }else {
                    mView.showEmpty();
                }

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
}
