/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.PasswordBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface EditPasswordContract {

    interface Model {

        Observable<String> doEditPassword(PasswordBo passwordBo);

    }

    interface View extends BaseView {
        /**
         * 关闭页面
         */
        void finishActivity();


        void showSuccessMsg(String msg);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);
    }


    interface Presenter extends BasePresenter {

        void editPassword(String passsword, String newPasssword, String reNewPasssword);
    }
}
