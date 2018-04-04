/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.presenter;

import com.suozhang.rentaluser.entity.bo.MyRoomBo;
import com.suozhang.rentaluser.feature.life.contract.MyRoomContract;
import com.suozhang.rentaluser.feature.life.dependencies.room.DaggerMyRoomPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class MyRoomPresenter implements MyRoomContract.Presenter {

    private MyRoomContract.View mView;

    @Inject

    MyRoomContract.Model mModel;


    public MyRoomPresenter(MyRoomContract.View mView) {
        this.mView = mView;
         DaggerMyRoomPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getMyRoomInfo() {
        mModel.doGetMyRoomInfo().compose(mView.<MyRoomBo>bindToLife()).subscribe(new Observer<MyRoomBo>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(MyRoomBo myLifeBo) {
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
}
