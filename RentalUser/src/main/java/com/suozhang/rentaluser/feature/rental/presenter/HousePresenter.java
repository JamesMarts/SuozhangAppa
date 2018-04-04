/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.presenter;

import com.suozhang.rentaluser.entity.bo.RentInfoBo;
import com.suozhang.rentaluser.feature.rental.contract.HouseContract;
import com.suozhang.rentaluser.feature.rental.dependencies.house.DaggerHousePresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class HousePresenter implements HouseContract.Presenter {

    private HouseContract.View mView;

    @Inject

    HouseContract.Model mModel;


    public HousePresenter(HouseContract.View mView) {
        this.mView = mView;

        DaggerHousePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void doGetRentInfo(String id) {
        mModel.doGetRentInfo(id).compose(mView.<RentInfoBo>bindToLife()).subscribe(new Observer<RentInfoBo>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull RentInfoBo rentInfoBo) {
                mView.showSuccess(rentInfoBo);
                mView.dismissLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void collectionHouse(String id) {
        mModel.collectionHouse(id).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.dismissLoading();
                mView.showCollectionSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showCollectionSuccessError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void cancleCollectionHouse(String id) {
        mModel.cancleCollectionHouse(id).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.dismissLoading();
                mView.showCancleCollectionSuccess(s);
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showCancleCollectionError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
