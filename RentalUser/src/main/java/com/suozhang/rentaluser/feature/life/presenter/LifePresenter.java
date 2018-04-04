/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.feature.life.contract.LifeContract;
import com.suozhang.rentaluser.feature.life.dependencies.life.DaggerLifePresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class LifePresenter implements LifeContract.Presenter {

    private LifeContract.View mView;

    @Inject

    LifeContract.Model mModel;


    public LifePresenter(LifeContract.View mView) {
        this.mView = mView;

         DaggerLifePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getMyRentState() {
        mModel.doGetMyRentState().compose(mView.<MyLifeBo>bindToLife()).subscribe(new Observer<MyLifeBo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(MyLifeBo myLifeBo) {
                mView.dismissLoading();
                mView.showSuccess(myLifeBo);
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
    public void doGetUnreadMessageCount() {
        mModel.doGetUnreadMessageCount().compose(mView.<Integer>bindToLife()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                mView.showMsgCount(integer);
            }

            @Override
            public void onError(Throwable e) {
                mView.showMsgCountError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
