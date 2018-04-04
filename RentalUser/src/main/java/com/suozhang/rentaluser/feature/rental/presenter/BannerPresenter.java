/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.presenter;

import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.feature.rental.contract.BannerContract;
import com.suozhang.rentaluser.feature.rental.dependencies.banner.DaggerBannerPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class BannerPresenter implements BannerContract.Presenter {

    private BannerContract.View mView;

    @Inject

    BannerContract.Model mModel;


    public BannerPresenter(BannerContract.View mView) {
        this.mView = mView;

        DaggerBannerPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void doGetBannerList() {
        mModel.doGetBannerList().compose(mView.<List<BannerBo>>bindToLife()).subscribe(new Observer<List<BannerBo>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<BannerBo> bannerBos) {
                mView.showSuccess(bannerBos);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getCityId(String cityName) {
        if (TextUtils.isEmpty(cityName)) {
            return;
        }
        mModel.doGetCityId(cityName).compose(mView.<BaseBo>bindToLife()).subscribe(new Observer<BaseBo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseBo baseBo) {
                mView.showAreaSuccess(baseBo);
            }

            @Override
            public void onError(Throwable e) {
                mView.showAreaErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void doGetLikeHouse(String areaId) {
        if (TextUtils.isEmpty(areaId)) {
            return;
        }
        mModel.doGetLikeHouse(areaId).compose(mView.<List<HouseRoomBo>>bindToLife()).subscribe(new Observer<List<HouseRoomBo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(List<HouseRoomBo> baseBo) {
                mView.dismissLoading();
                if (baseBo != null && baseBo.size() > 0) {
                    mView.showLikeHouseSuccess(baseBo);
                } else {
                    mView.showLikeHouseEmpty();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissLoading();
                mView.showLikeHouseError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
