/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import android.text.TextUtils;

import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.EditNameContract;
import com.suozhang.rentaluser.feature.user.dependencies.editname.DaggerEditNamePresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class EditNamePresenter implements EditNameContract.Presenter {

    private EditNameContract.View mView;

    @Inject

    EditNameContract.Model mModel;


    public EditNamePresenter(EditNameContract.View mView) {
        this.mView = mView;

         DaggerEditNamePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void doEditName(String nickName) {
        if (TextUtils.isEmpty(nickName)) {
            T.showShort("请输入用户昵称！");
            return;
        }
        UserInfoBo userInfoBo = new UserInfoBo();
        userInfoBo.setNickName(nickName);
        mModel.doEditName(userInfoBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(@NonNull String s) {
                mView.showSuccessMsg(s);

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


}
