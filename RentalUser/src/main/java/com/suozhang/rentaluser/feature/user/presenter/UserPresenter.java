/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.UserCenterContract;
import com.suozhang.rentaluser.feature.user.dependencies.ediruser.DaggerUserPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class UserPresenter implements UserCenterContract.Presenter {

    private UserCenterContract.View mView;

    @Inject

    UserCenterContract.Model mModel;


    public UserPresenter(UserCenterContract.View mView) {
        this.mView = mView;

        DaggerUserPresenterComponent.create().inject(this);

    }

    @Override
    public void start() {

    }


    @Override
    public void getUserInfo() {
        mModel.doUserInfo().compose(mView.<UserInfoBo>bindToLife()).subscribe(new Observer<UserInfoBo>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull UserInfoBo userInfoBo) {
                mView.showUserInfo(userInfoBo);
            }

            @Override
            public void onError(@NonNull Throwable e) {
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
