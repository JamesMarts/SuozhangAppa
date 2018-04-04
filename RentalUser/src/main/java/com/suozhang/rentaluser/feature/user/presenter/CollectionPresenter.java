/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.feature.user.contract.CollectionContract;
import com.suozhang.rentaluser.feature.user.dependencies.collection.DaggerCollectionPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class CollectionPresenter implements CollectionContract.Presenter {

    private CollectionContract.View mView;

    @Inject

    CollectionContract.Model mModel;

    public CollectionPresenter(CollectionContract.View mView) {
        this.mView = mView;

        DaggerCollectionPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getCollectionList() {
        mModel.doGetCollectionList().compose(mView.<List<HouseRoomBo>>bindToLife()).subscribe(new Observer<List<HouseRoomBo>>() {
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
                mView.showErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
