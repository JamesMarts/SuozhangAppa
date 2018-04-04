/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.ZMBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface CertificationContract {

    interface Model {

        Observable<String> doEditName(String card, String name);

        Observable<ZMBo> doCheckZhimaScore();

    }

    interface View extends BaseView {


        void showSuccessMsg(String msg);

        void showZMSuccessMsg(ZMBo msg);

        void showZMErrorMsg(String msg);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);

    }


    interface Presenter extends BasePresenter {
        void doEditName(String card, String name);

        void doCheckZhimaScore();
    }
}
