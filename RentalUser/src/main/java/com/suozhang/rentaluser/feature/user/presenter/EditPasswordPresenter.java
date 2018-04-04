/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.presenter;

import android.text.TextUtils;

import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.feature.user.contract.EditPasswordContract;
import com.suozhang.rentaluser.feature.user.dependencies.editpwd.DaggerEditPasswordPresenterComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class EditPasswordPresenter implements EditPasswordContract.Presenter {

    private EditPasswordContract.View mView;

    @Inject

    EditPasswordContract.Model mModel;


    public EditPasswordPresenter(EditPasswordContract.View mView) {
        this.mView = mView;

        DaggerEditPasswordPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void editPassword(String password, String newPassword, String reNewPassword) {
        if (TextUtils.isEmpty(password)) {
            T.showShort("请输入原始密码！");
            return;
        }
        if (TextUtils.isEmpty(newPassword)) {
            T.showShort("请输入新密码！");
            return;
        }
        if (TextUtils.isEmpty(reNewPassword)) {
            T.showShort("请输入再次输入新密码！");
            return;
        }
        PasswordBo passwordBo = new PasswordBo(password, newPassword, reNewPassword);
        mModel.doEditPassword(passwordBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
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

