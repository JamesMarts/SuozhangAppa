package com.suozhang.rentaluser.feature.user.presenter;

import android.text.TextUtils;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.utils.ValidatorUtil;
import com.suozhang.rentaluser.entity.bo.RegisterBo;
import com.suozhang.rentaluser.feature.user.contract.ModifyPhoneContract;
import com.suozhang.rentaluser.feature.user.dependencies.modifyphone.DaggerModifyPhonePresenterComponent;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/18 14:27
 */

public class ModifyPhonePresenter implements ModifyPhoneContract.Presenter {

    private ModifyPhoneContract.View mView;

    @Inject
    ModifyPhoneContract.Model mModel;

    private Disposable mDisposable;

    public ModifyPhonePresenter(ModifyPhoneContract.View mView) {
        this.mView = mView;
        DaggerModifyPhonePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void sendCode(String phone) {

        if (TextUtils.isEmpty(phone)) {
            mView.showErrorMsg("请输入手机号！");
            return;
        }

        if (!ValidatorUtil.isMobile(phone)) {
            mView.showErrorMsg("手机号格式有误!");
            return;
        }
        mModel.doSendCode(phone, 1)
                .compose(mView.<String>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<String>(mView) {
                    @Override
                    public void onNext(@NonNull String s) {
                        countdown();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        disposeCountdown();
                    }
                });
    }

    @Override
    public void modifyPhone(String oldPhone, String newPhone, String code) {
        if (TextUtils.isEmpty(oldPhone) || !ValidatorUtil.isMobile(oldPhone)) {
            mView.showErrorMsg("旧手机号输入有误");
            return;
        }
        if (TextUtils.isEmpty(newPhone) || !ValidatorUtil.isMobile(newPhone)) {
            mView.showErrorMsg("新手机号输入有误");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            mView.showErrorMsg("请输入验证码");
            return;
        }
        RegisterBo info = new RegisterBo();
        info.setOldPhone(oldPhone);
        info.setPhone(newPhone);
        info.setCode(code);

        mModel.doModifyPhone(info)
                .compose(mView.<String>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<String>(mView) {
                    @Override
                    public void onNext(@NonNull String s) {
                        mView.showMsg("修改绑定手机成功，请使用新手机号重新登录");
                        mView.finishUi();
                    }
                });
    }

    /**
     * 取消倒计时
     */
    private void disposeCountdown() {
        if (mDisposable != null) {
            mDisposable.dispose();
            mDisposable = null;
        }
        mView.setResendEnabled(true);
    }

    /**
     * 倒计时
     */
    private void countdown() {
        disposeCountdown();
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(61)
                .compose(mView.<Long>bindToLife())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                        mView.setResendEnabled(false);
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        long time = 60 - aLong;
                        mView.setResendCountdown(time + "s后重试");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mView.setResendEnabled(true);
                    }
                });
    }
}
