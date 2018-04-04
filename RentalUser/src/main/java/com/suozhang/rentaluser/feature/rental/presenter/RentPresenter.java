/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.presenter;

import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.DaggerRentPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class RentPresenter implements RentContract.Presenter {

    private RentContract.View mView;

    @Inject

    RentContract.Model mModel;


    public RentPresenter(RentContract.View mView) {
        this.mView = mView;

         DaggerRentPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getHouseingResourseByFilter(RentParamsBo rentParamsBo) {
        mModel.doGetHouseingResourseByFilter(rentParamsBo).compose(mView.<List<HouseRoomBo>>bindToLife()).subscribe(new Observer<List<HouseRoomBo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(List<HouseRoomBo> houseRoomBos) {
                mView.dismissLoading();
                if (houseRoomBos.size() > 0) {
                    mView.showSuccess(houseRoomBos);
                } else {
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
