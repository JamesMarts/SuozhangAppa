/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.rental.presenter;

import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.ReportBo;
import com.suozhang.rentaluser.feature.rental.contract.ReportContract;
import com.suozhang.rentaluser.feature.rental.dependencies.report.DaggerReportPresenterComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:31
 */
public class ReportPresenter implements ReportContract.Presenter {

    private ReportContract.View mView;

    @Inject

    ReportContract.Model mModel;


    public ReportPresenter(ReportContract.View mView) {
        this.mView = mView;

        DaggerReportPresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void doGetReportType() {
        mModel.doGetReportType().compose(mView.<List<BaseBo>>bindToLife()).subscribe(new Observer<List<BaseBo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<BaseBo> baseBos) {
                mView.showSuccess(baseBos);
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMsg(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void doReportHouse(String reportTypeId, String houdeId, String reason) {
        if (TextUtils.isEmpty(reportTypeId)){
            mView.showMsg("请选择举报理由！");
            return;
        }

        if (TextUtils.isEmpty(houdeId)){
            return;
        }
        ReportBo reportBo = new ReportBo(reportTypeId, houdeId, reason);
        mModel.doReportHouse(reportBo).compose(mView.<String>bindToLife()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mView.showLoading(d);
            }

            @Override
            public void onNext(String s) {
                mView.showReportSuccess(s);
                mView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.showReportErrorMsg(e.getMessage());
                mView.dismissLoading();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }
        });
    }
}
