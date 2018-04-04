/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;


import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.StringDateBo;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.UserInfoContract;
import com.suozhang.rentaluser.feature.user.dependencies.userinfo.DaggerUserInfoPresenterComponent;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class UserInfoPresenter implements UserInfoContract.Presenter {

    private UserInfoContract.View mView;

    @Inject

    UserInfoContract.Model mModel;


    public UserInfoPresenter(UserInfoContract.View mView) {
        this.mView = mView;

        DaggerUserInfoPresenterComponent.create().inject(this);

    }

    @Override
    public void start() {

    }


    @Override
    public void updateUserIcon(int uploadImgType, File file) {
        mModel.doUpdateUserIcon(uploadImgType, file)
                .compose(mView.<String>bindToLife())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mView.showLoading(d);
                    }

                    @Override
                    public void onNext(String s) {
                        mView.showUploadSuccess(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissLoading();
                        mView.showUploadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.dismissLoading();
                    }
                });
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
    public void editBirthday(String birthady) {
        StringDateBo stringDateBo = new StringDateBo(birthady);



        mModel.doEditBirthday(stringDateBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showEditBirthdaySuccess(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showEditBirthdayErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void doEditGender(boolean gender) {
        UserInfoBo userInfoBo = new UserInfoBo();
        userInfoBo.setSex(gender);
        mModel.doEditGender(userInfoBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showEditBirthdaySuccess(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showEditBirthdayErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }

    @Override
    public void editStar(String star) {
        if (TextUtils.isEmpty(star)){
            return;
        }

        BaseBo userInfoBo = new BaseBo(star);

        mModel.doEditStar(userInfoBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showEditBirthdaySuccess(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.showEditBirthdayErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
